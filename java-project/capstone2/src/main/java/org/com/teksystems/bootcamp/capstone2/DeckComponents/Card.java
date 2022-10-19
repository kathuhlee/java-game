package org.com.teksystems.bootcamp.capstone2.DeckComponents;

public class Card {

    private Suit suit;
    private int number;

    public Card(Suit pickedSuit, int pickedNumber) {
        this.suit = pickedSuit;

        if (pickedNumber >= 1 && pickedNumber <= 13) {
            this.number = pickedNumber;
        } else {
            System.err.println(number + " is not a card number");
//            System.exit(1);
            // throw an exception
        }
    }

    public int getNumber() {
        return number;
    }

    public String getSuit(){
        return suit.name.toString();
    }
    // polymorphism
    @Override
    public String toString() {

        String numString = "Error";

        switch(this.number) {

            case 1:
                numString = "Ace";
                break;
            case 2:
                numString = "Two";
                break;
            case 3:
                numString = "Three";
                break;
            case 4:
                numString = "Four";
                break;
            case 5:
                numString = "Five";
                break;
            case 6:
                numString = "Six";
                break;
            case 7:
                numString = "Seven";
                break;
            case 8:
                numString = "Eight";
                break;
            case 9:
                numString = "Nine";
                break;
            case 10:
                numString = "Ten";
                break;
            case 11:
                numString = "Jack";
                break;
            case 12:
                numString = "Queen";
                break;
            case 13:
                numString = "King";
                break;

        }

        return numString + " of " + suit.name.toString();
    }
}