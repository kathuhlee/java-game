package org.com.teksystems.bootcamp.capstone2.DeckComponents;

public enum Suit {
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    SPADES("Spades");

    final String name;
    Suit(String name) {
        this.name = name;
    }
}