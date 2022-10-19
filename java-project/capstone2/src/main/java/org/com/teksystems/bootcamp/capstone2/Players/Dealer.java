package org.com.teksystems.bootcamp.capstone2.Players;

import org.com.teksystems.bootcamp.capstone2.DeckComponents.Card;
import org.com.teksystems.bootcamp.capstone2.DeckComponents.Deck;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

    private final Deck deck;

    public Dealer(Deck deck) {
        super("Dealer");
        this.deck = deck;
    }

    public Dealer() {
        super("Dealer");
        this.deck = new Deck();
    }

    public void renewDeck(int numDecks) {
        deck.renewDeck(numDecks);
    }

    public void shuffle() {
        deck.shuffle();
    }

    public Card dealCard() {
        return deck.dealCard();
    }

    public List<Card> dealHands() {
        hand = new ArrayList<Card>();
        List<Card> playerHand = new ArrayList<Card>();
        hand.add(dealCard());
        hand.add(dealCard());
        playerHand.add(dealCard());
        playerHand.add(dealCard());

        return playerHand;
    }

}