package org.com.teksystems.bootcamp.capstone2.Players;

import org.com.teksystems.bootcamp.capstone2.DeckComponents.Card;

import java.util.List;

public class Player {

    private String name;
    protected List<Card> hand;
    public int wins;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public Player(String playerName) {
        name = playerName;
        wins = 0;

//        this.emptyHand();
    }
    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }
    public void setHand(List<Card> h) {
        hand = h;
    }

    public void emptyHand() {
        hand.clear();
    }

    public boolean addCard(Card card) {
        if (hand.size() == 10) {
            System.err.printf("%s's hand already has a max of 10 cards. \n" + "You cannot add another card", this.name);
            System.exit(1);
        }
        hand.add(card);

        return (sumOfHand() <= 21);
    }
// calculate the sum of hand by having cards 2-10 equal to their case number
// face cards are set to 10
    // ace is set to 11
// ace is set to 1 if sum is greater than 21

    public int sumOfHand() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        for (Card value : hand) {
            cardNum = value.getNumber();

            if (cardNum == 1) {
                numAces++;
                handSum += 11;
            } else if (cardNum > 10) {
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }

        while (handSum > 21 && numAces > 0) {
            handSum -= 10;
            numAces--;
        }

        return handSum;
    }

    // print hand for player with all cards revealed, print hand for dealer with first card being hidden
    public void printHand(boolean showFirstCard) {
        System.out.printf("\n%s's cards:\n", name);
        for (int card = 0; card < hand.size(); card++) {
            if (card == 0 && !showFirstCard) {
                System.out.println(ANSI_RED + " ** Card is Hidden **" + ANSI_RESET);
            } else {
                System.out.printf(ANSI_YELLOW + " %s\n", hand.get(card).toString() + ANSI_RESET);
            }
        }
    }

}