package org.com.teksystems.bootcamp.capstone2.RunGame;

import org.com.teksystems.bootcamp.capstone2.Players.Dealer;
import org.com.teksystems.bootcamp.capstone2.Players.Player;

import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class BlackJack {
    //attributes -- data -- fields -- variables
    private final Scanner sc;
    private int mySum;
    private int dealerSum = 0;
    private Player user = new Player("Player One");
    private Dealer dealer = new Dealer();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

    //constructor
    public BlackJack() {
        sc = new Scanner(System.in);
//        myDeck = new Deck(1, true);
    }

    //methods
    public void run() {
        boolean play = true;

        user = new Player("Player One");
        dealer = new Dealer();

        String choice;

        while (play) {
            user.setHand(dealer.dealHands());

            System.out.println(
                    ANSI_GREEN +
                            "\n\n------------------------------------------------" + ANSI_RESET +
                            ANSI_CYAN +
                            "\n-------------------- Welcome! ------------------" +
                            "\n---------- Let's play some BlackJack. ----------" +
                            "\n- The game is played between you and a dealer. -" +
                            "\n--------------- You are Player One. ------------" + ANSI_RESET +
                            ANSI_GREEN +
                            "\n------------------------------------------------" + ANSI_RESET +
                            ANSI_YELLOW +
                            "\n\n------------- Cards have been dealt. -----------" + ANSI_RESET);
            user.printHand(true);
            dealer.printHand(false);

            PlayHand.playHand(user, dealer, sc);
            mySum = user.sumOfHand();
            dealerSum = dealer.sumOfHand();

            System.out.println();

            user.printHand(true);
            dealer.printHand(true);

            WinState.displayOutcome(user, dealer);

            System.out.print(
                    ANSI_PURPLE +
                            "\n---------- Do you want to play again? ----------" +
                            ANSI_RESET +
                            ANSI_BLUE +
                            "\n  Y is a Yes to relive your experiences of \n    playing this amazing game again. " +
                            "\n------------------------------------------------" +
                            "\n  N is a No as you want to live your best \n   life outside of blackjack." +
                            "\n------------------------------------------------" +
                            ANSI_RESET +
                            ANSI_PURPLE +
                            "\n      Choose your destiny! Enter Y or N: " +
                            ANSI_RESET);
            choice = sc.nextLine().strip().toUpperCase();
            if (choice.charAt(0) == 'N') {
                play = false;
            } else if (choice.charAt(0) == 'Y') {
                dealer.renewDeck(1);
                dealer.shuffle();
            } else {
                System.out.println(ANSI_RED +
                        "\n* That is not a Y or N, but let's play again! *" +
                        ANSI_RESET);
            }
        }
        sc.close();
    }
}