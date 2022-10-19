package org.com.teksystems.bootcamp.capstone2.DeckComponents;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    private Random randomNum;

    // overloading
    public Deck() {
        this(1, true);
    }
    // generating a new deck and shuffling
    public Deck(int numDecks, boolean shuffle) {

        randomNum = new Random(System.currentTimeMillis());
        renewDeck(numDecks);

        if (shuffle) {
            shuffle();
        }

    }
    //used for testing the cards in deck, if they are shuffling correctly, etc
    public int cardsRemainingInDeck() {
        return cards.size();
    }

    public void shuffle() {

        for (int i = 0; i < cards.size() * 4; i++) {
            int j = randomNum.nextInt(cards.size());
            Card placeholder = cards.remove(j);
            cards.add(placeholder);
        }
    }
    // deal cards by using ternary operator to remove top card
    public Card dealCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
    // used to verify cards in deck when testing
    public void printDeck(int printNum) {
        if (printNum >= cards.size()) {
            printNum = cards.size();
        }

        for (int card = 0; card < printNum; card++) {
            System.out.printf("%3d/%d %s\n", card + 1, cards.size(), cards.get(card).toString());
        }
        System.out.printf("[%d cards remaining in deck]\n", cards.size() - printNum);
    }

    public void printDeck() {
        for (int card = 0; card < cards.size(); card++) {
            System.out.println(cards.get(card).toString());
        }
    }

    public void renewDeck(int numDecks) {
        cards = new ArrayList<>();

        for (Suit s : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                for (int j = 0; j < numDecks; j++) {
                    cards.add(new Card(s, i));
                }
            }
        }
//        shuffle();
    }
}