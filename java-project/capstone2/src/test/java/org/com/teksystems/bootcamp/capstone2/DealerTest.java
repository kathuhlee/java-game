package org.com.teksystems.bootcamp.capstone2;

import org.com.teksystems.bootcamp.capstone2.DeckComponents.Card;
import org.com.teksystems.bootcamp.capstone2.DeckComponents.Deck;
import org.com.teksystems.bootcamp.capstone2.DeckComponents.Suit;
import org.com.teksystems.bootcamp.capstone2.Players.Dealer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    private Deck deck;

    public DealerTest()
    {
        deck = new Deck();
    }

    @Test
    public void constructor(){
        Dealer dealer = new Dealer(deck);

        assertEquals("Dealer", dealer.getName());
        assertEquals(0, dealer.wins);
    }

    @Test
    public void setHand() {
        Dealer dealer = new Dealer();
        List<Card> aList = new ArrayList<Card>();

        aList.add(new Card(Suit.DIAMONDS, 3));
        aList.add(new Card(Suit.DIAMONDS, 5));
        aList.add(new Card(Suit.DIAMONDS, 7));

        dealer.setHand(aList);

        List<Card> playerHand = dealer.getHand();

        for (int i = 0; i < aList.size(); i++) {
            assertEquals(aList.get(i).getNumber(), playerHand.get(i).getNumber());
            assertEquals(aList.get(i).getSuit(), playerHand.get(i).getSuit());
        }

    }
}