package org.com.teksystems.bootcamp.capstone2;

import org.com.teksystems.bootcamp.capstone2.DeckComponents.Card;
import org.com.teksystems.bootcamp.capstone2.DeckComponents.Deck;
import org.com.teksystems.bootcamp.capstone2.DeckComponents.Suit;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void organizedDeck() {
        //create organized single deck
        Deck aDeck = new Deck(1, false); //single deck and not shuffled;
        assertEquals(52, aDeck.cardsRemainingInDeck());

        int index = 0;  //first card in deck
        //verify that cards are in order
        // as we go through new cards, as num decrements, the # is equal to cards in deck
        // when we deal a card, we ensure the number on card matches number in deck
        int numOfCards = 52;
        for (Suit s : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                Card aCard = new Card(s, i);
                assertEquals(numOfCards--, aDeck.cardsRemainingInDeck());
                Card fromDeck = aDeck.dealCard();
                assertEquals(aCard.getNumber(), fromDeck.getNumber());
            }
        }
    }

    @Test
    public void shuffledDeck() {  //default constructor
        //implies a single deck of cards that is shuffled
        Deck aDeck = new Deck(); //single deck and shuffled;
        assertEquals(52, aDeck.cardsRemainingInDeck());
        //verify that cards are out-of-order
        boolean inOrder = true;
        for (Suit s : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                Card aCard = new Card(s, i);
                Card fromDeck = aDeck.dealCard();
                if (aCard.getNumber() != fromDeck.getNumber()) {
                    inOrder = false;
                }
            }
        }

        assertFalse(inOrder);
    }

    @Test
    public void multipleDecks() {
        // for up to 5 decks
        for (int decks = 1; decks <= 5; decks++) {
            Deck aDeck = new Deck(decks, true);
            assertEquals(decks * 52, aDeck.cardsRemainingInDeck());
        }
    }

    @Test
    public void cardsRemaining() {
        //create a single deck of 52 cards
        Deck aDeck = new Deck();
        for (int i = 52; i > 0; i--) {
            assertEquals(i, aDeck.cardsRemainingInDeck());
            aDeck.dealCard();
        }
    }

    @Test
    public void dealCards() {
        Deck aDeck = new Deck(1, false);
        for (Suit s : Suit.values()) {
            for (int i = 1; i < 14; i++) {
                Card aCard = new Card(s, i);
                Card fromDeck = aDeck.dealCard();
                assertEquals(aCard.getNumber(), fromDeck.getNumber());
                assertEquals(aCard.getSuit(), fromDeck.getSuit());
            }
        }
    }

    //unhappy tests
    @Test
    public void nullCardDealt() {
        Deck aDeck = new Deck();  //1 deck shuffled

        assertEquals(52, aDeck.cardsRemainingInDeck());

        //deal out all 52 cards
        for (int i = 0; i < 52; i++) {
            aDeck.dealCard();
        }

        //unhappy state
        assertNull(aDeck.dealCard());
    }
}