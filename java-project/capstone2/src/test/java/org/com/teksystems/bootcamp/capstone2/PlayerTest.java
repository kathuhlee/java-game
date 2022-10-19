package org.com.teksystems.bootcamp.capstone2;

import org.com.teksystems.bootcamp.capstone2.DeckComponents.Card;
import org.com.teksystems.bootcamp.capstone2.DeckComponents.Suit;
import org.com.teksystems.bootcamp.capstone2.Players.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void constructor() {
        //create a player
        Player player = new Player("Test name");

        assertEquals("Test name", player.getName());
        assertEquals(0, player.wins);
    }

    @Test
    public void setHand() {
        Player player = new Player("Name");
        List<Card> aList = new ArrayList<Card>();

        // verifying cards are made correctly and put into list to setHand
        aList.add(new Card(Suit.DIAMONDS, 3));
        aList.add(new Card(Suit.DIAMONDS, 5));
        aList.add(new Card(Suit.DIAMONDS, 7));

        player.setHand(aList);

        List<Card> playerHand = player.getHand();

        for (int i = 0; i < aList.size(); i++) {
            assertEquals(aList.get(i).getNumber(), playerHand.get(i).getNumber());
            assertEquals(aList.get(i).getSuit(), playerHand.get(i).getSuit());
        }

    }
}