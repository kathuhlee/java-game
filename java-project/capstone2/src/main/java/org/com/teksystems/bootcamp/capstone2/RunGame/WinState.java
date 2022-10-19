package org.com.teksystems.bootcamp.capstone2.RunGame;

import org.com.teksystems.bootcamp.capstone2.Players.Dealer;
import org.com.teksystems.bootcamp.capstone2.Players.Player;

public class WinState {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void displayOutcome(Player user, Dealer dealer) {
        int mySum = user.sumOfHand();
        int dealerSum = dealer.sumOfHand();

        System.out.println(ANSI_GREEN +
                "\nPlayer One's hand: " + mySum + ", Dealer's hand: " + dealerSum +
                ANSI_RESET);

        if (mySum > 21) {
            System.out.println(ANSI_PURPLE +
                    "\nPlayer busts!!! Bummer! \nThe Dealer wins this round." +
                    ANSI_RESET);
            dealer.wins++;
        } else if (mySum == 21) {
            System.out.println(ANSI_YELLOW +
                    "\nBlackJack!!! Go you! You win this round." +
                    ANSI_RESET);
            user.wins++;
        } else if (mySum > dealerSum || dealerSum > 21) {
            System.out.println(ANSI_YELLOW +
                    "\nWinner, winner, chicken dinner!!! \nYou get an imaginary golden star." +
                    ANSI_RESET);
            user.wins++;
        } else if (mySum == dealerSum) {
            System.out.println(ANSI_RED +
                    "\nPush!!! It's a tie. \nIt's as if nothing happened.\nPoints stay the same." +
                    ANSI_RESET);
        } else {
            System.out.println(ANSI_PURPLE +
                    "\nDealer is the winner!!! \nYou can play again to redeem your honor!" +
                    ANSI_RESET);
            dealer.wins++;
        }

        System.out.printf(ANSI_CYAN +
                "\n-------------------- SCORES --------------------" +
                ANSI_RESET +
                "\nPlayer:%2d Dealer:%2d\n", user.wins, dealer.wins);

    }
}