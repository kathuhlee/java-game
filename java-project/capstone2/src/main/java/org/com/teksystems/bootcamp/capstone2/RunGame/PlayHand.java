package org.com.teksystems.bootcamp.capstone2.RunGame;

import org.com.teksystems.bootcamp.capstone2.Players.Dealer;
import org.com.teksystems.bootcamp.capstone2.Players.Player;

import java.util.Scanner;

public class PlayHand {
    //attributes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void playHand(Player user, Dealer dealer, Scanner sc) {
        boolean userIsDone = false;
        boolean dealerIsDone = false;
        String end;
        int mySum = user.sumOfHand();
        int dealerSum = dealer.sumOfHand();

        while (!userIsDone || !dealerIsDone) {
            while (user.sumOfHand() < 21 && !userIsDone) {
                System.out.print(ANSI_GREEN +
                        "\n------------------------------------------------" +
                        "\nDo you want to Hit or Stay? Enter H or S: " +
                        ANSI_RESET);
                end = sc.nextLine().strip().toUpperCase();
                System.out.println();

                switch (end.charAt(0)) {
                    case 'H':
                        userIsDone = !user.addCard(dealer.dealCard());
                        mySum = user.sumOfHand();
                        user.printHand(true);
                        System.out.println(ANSI_GREEN +
                                "\n------------------------------------------------" +
                                ANSI_RESET);
                        break;
                    case 'S':
                        userIsDone = true;
                        break;
                    default:
                        System.out.println(ANSI_RED +
                                "Invalid entry, try again!" +
                                ANSI_RESET);
                        continue;
                }

                if (mySum >= 21) {
                    break;
                }
            }

            while (mySum < 22 && !dealerIsDone) {
                if (dealerSum < 17) {
                    System.out.println(ANSI_GREEN +
                            "The Dealer hits. \n " +
                            "\n------------------------------------------------" +
                            ANSI_RESET);
                    dealerIsDone = !dealer.addCard(dealer.dealCard());
                    dealerSum = dealer.sumOfHand();
                    dealer.printHand((true));
                    System.out.println(ANSI_GREEN +
                            "\n------------------------------------------------" +
                            ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN +
                            "The Dealer stays. \n" +
                            "\n------------------------------------------------" +
                            ANSI_RESET);
                    dealerIsDone = true;
                }
            }

            if ((mySum > 21) || (mySum > dealerSum && dealerIsDone)) {
                break;
            }
        }
    }


}