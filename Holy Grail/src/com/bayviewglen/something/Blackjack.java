/*
 * Name: Mathew Jennings
 * Course: ICS3U
 * Title: Blackjack Assignment
 * Game created to let users play blackjack on the computer
 * Due Date: December 5th
 */
package com.bayviewglen.something;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Blackjack {
    public static int CLUBS = 1;
    public static int SPADES = 2;
    public static int HEARTS = 3;
    public static int DIAMONDS = 4;
    public static int BLACKJACK_LUCKY_NUMBER_ONE = 21 - 10;
    public static int BLACKJACK_LUCKY_NUMBER_TWO = 21 - 11;
    public static int DEALER_MAX = 17;
    public static int BUST = 21;
    public static int ACE_LOW = 1;
    public static int ACE_HIGH = 11;
    public static int ACE = 1;
    public static int JACK = 11;
    public static int QUEEN = 12;
    public static int KING = 13;
    public static int FACE_CARD_POINTS = 10;
    public static int TOTAL_CARDS_PER_SUITE = 13;
    public static int TOTAL_NUMBER_OF_SUITES = 4;

    public int playBlackJack (String name) {
   
       
            // 5 spaces back or forward
            int wallet = 5;
                     
                
               
          
                	// How many spots
                    int bet = getBet(wallet, name);

                    // Gets players cards at random, adds them to a string.
                    String playersCards = "";
                    int playersPoints = 0;
                    int playersAces = 0;

                    for (int i = 0; i < 2; i++) {
                        int card1 = (int)(Math.random() * TOTAL_CARDS_PER_SUITE + 1);
                        int suite = (int)(Math.random() * TOTAL_NUMBER_OF_SUITES + 1);
                        if (card1 == ACE) {
                            playersCards += "A";
                            playersPoints += ACE_HIGH;
                            playersAces++;
                        } else if (card1 == JACK) {
                            playersCards += "J";
                            playersPoints += FACE_CARD_POINTS;
                        } else if (card1 == QUEEN) {
                            playersCards += "Q";
                            playersPoints += FACE_CARD_POINTS;
                        } else if (card1 == KING) {
                            playersCards += "K";
                            playersPoints += FACE_CARD_POINTS;
                        } else {
                            playersCards += "" + card1;
                            playersPoints += card1;
                        }
                        if (suite == CLUBS) {
                            playersCards += "C ";
                        } else if (suite == SPADES) {
                            playersCards += "S ";
                        } else if (suite == HEARTS) {
                            playersCards += "H ";
                        } else {
                            playersCards += "D ";
                        }

                    }

                    // Gets dealer's cards at random, adds them to a string.
                    String dealersCards = "";
                    int dealersPoints = 0;
                    int dealersAces = 0;
                    String dealersDisplayCards = "";
                    for (int i = 0; i < 2; i++) {
                        int card1 = (int)(Math.random() * TOTAL_CARDS_PER_SUITE + 1);
                        int suite = (int)(Math.random() * TOTAL_NUMBER_OF_SUITES + 1);
                        if (card1 == 1) {
                            dealersCards += "A";
                            dealersPoints += ACE_HIGH;
                            dealersAces++;
                        } else if (card1 == JACK) {
                            dealersCards += "J";
                            dealersPoints += FACE_CARD_POINTS;
                        } else if (card1 == QUEEN) {
                            dealersCards += "Q";
                            dealersPoints += FACE_CARD_POINTS;
                        } else if (card1 == KING) {
                            dealersCards += "K";
                            dealersPoints += FACE_CARD_POINTS;
                        } else {
                            dealersCards += "" + card1;
                            dealersPoints += card1;
                        }
                        if (suite == CLUBS) {
                            dealersCards += "C ";
                        } else if (suite == SPADES) {
                            dealersCards += "S ";
                        } else if (suite == HEARTS) {
                            dealersCards += "H ";
                        } else {
                            dealersCards += "D ";
                        }
                        if (i == 0) {
                            dealersCards += "& ";
                            dealersDisplayCards += dealersCards;
                        }
                    }
                    dealersDisplayCards += "XX";

                    // Tells player the cards
                    System.out.println(name + ", your cards are:\n" + playersCards + "\nand the dealers cards are:\n" + dealersDisplayCards);

                    // Dealer Plays
                    while (dealersPoints < DEALER_MAX) {
                        int card1 = (int)(Math.random() * TOTAL_CARDS_PER_SUITE + 1);
                        int suite = (int)(Math.random() * TOTAL_NUMBER_OF_SUITES + 1);
                        dealersCards += "& ";
                        if (card1 == ACE) {
                            dealersCards += "A";
                            dealersPoints += ACE_HIGH;
                            dealersAces++;
                        } else if (card1 == JACK) {
                            dealersCards += "J";
                            dealersPoints += FACE_CARD_POINTS;
                        } else if (card1 == QUEEN) {
                            dealersCards += "Q";
                            dealersPoints += FACE_CARD_POINTS;
                        } else if (card1 == KING) {
                            dealersCards += "K";
                            dealersPoints += FACE_CARD_POINTS;
                        } else {
                            dealersCards += "" + card1;
                            dealersPoints += card1;
                        }
                        if (suite == CLUBS) {
                            dealersCards += "C ";
                        } else if (suite == SPADES) {
                            dealersCards += "S ";
                        } else if (suite == HEARTS) {
                            dealersCards += "H ";
                        } else {
                            dealersCards += "D ";
                        }
                        if (dealersPoints > BUST && dealersAces > 0) {
                            dealersPoints -= BLACKJACK_LUCKY_NUMBER_TWO;
                            dealersAces--;
                        }
                        dealersDisplayCards += " & XX ";
                    }

                    // Refer to method that asks for bet / other.
                    int hit;
                    if (bet > wallet / 2) {
                        hit = getHitNoDD();
                    } else {
                        hit = getHit();
                    }

                    // If Player hits, get card, loop until player does not hit
                    while (hit == 1) {
                        int card1 = (int)(Math.random() * TOTAL_CARDS_PER_SUITE + 1);
                        int suite = (int)(Math.random() * TOTAL_NUMBER_OF_SUITES + 1);
                        if (card1 == ACE) {
                            playersCards += "A";
                            playersPoints += ACE_HIGH;
                            playersAces++;
                        } else if (card1 == JACK) {
                            playersCards += "J";
                            playersPoints += FACE_CARD_POINTS;
                        } else if (card1 == QUEEN) {
                            playersCards += "Q";
                            playersPoints += FACE_CARD_POINTS;
                        } else if (card1 == KING) {
                            playersCards += "K";
                            playersPoints += FACE_CARD_POINTS;
                        } else {
                            playersCards += "" + card1;
                            playersPoints += card1;
                        }

                        if (suite == CLUBS) {
                            playersCards += "C ";
                        } else if (suite == SPADES) {
                            playersCards += "S ";
                        } else if (suite == HEARTS) {
                            playersCards += "H ";
                        } else {
                            playersCards += "D ";
                        }
                        if (playersPoints > BUST && playersAces > 0) {
                            playersPoints -= BLACKJACK_LUCKY_NUMBER_TWO;
                            playersAces--;
                        }
                        if (playersPoints < BUST) {
                            System.out.println(name + ", your cards are\n" + playersCards + "\nand you have " + playersPoints + " points.");
                            hit = getHitNoDD();
                        } else {
                            hit = 2;
                        }
                    }

                    // If player doubles down, do what is suppose to happen,
                    // otherwise move on
                    boolean finnishRound = false;
                    while (!finnishRound) {
                        if (hit == 3) {
                            int tempBet = bet;
                            bet = tempBet * 2;
                            finnishRound = true;
                            int card1 = (int)(Math.random() * TOTAL_CARDS_PER_SUITE + 1);
                            int suite = (int)(Math.random() * TOTAL_NUMBER_OF_SUITES + 1);
                            if (card1 == ACE) {
                                playersCards += "A";
                                playersPoints += ACE_HIGH;
                            } else if (card1 == JACK) {
                                playersCards += "J";
                                playersPoints += FACE_CARD_POINTS;
                            } else if (card1 == QUEEN) {
                                playersCards += "Q";
                                playersPoints += FACE_CARD_POINTS;
                            } else if (card1 == KING) {
                                playersCards += "K";
                                playersPoints += FACE_CARD_POINTS;
                            } else {
                                playersCards += "" + card1;
                                playersPoints += card1;
                            }

                            if (suite == CLUBS) {
                                playersCards += "C ";
                            } else if (suite == SPADES) {
                                playersCards += "S ";
                            } else if (suite == HEARTS) {
                                playersCards += "H ";
                            } else {
                                playersCards += "D ";
                            }
                            if (dealersPoints > BUST && dealersAces > 0) {
                                dealersPoints -= BLACKJACK_LUCKY_NUMBER_TWO;
                                dealersAces--;
                            }
                            finnishRound = true;
                        } else {
                            finnishRound = true;
                        }
                    }

                    // Find out if they won, tied, or lost
                    boolean win = false;
                    String didWin = "";
                    if (dealersPoints > BUST && playersPoints > BUST) {
                        didWin = "you tied";
                        wallet -= bet;
                    } else if (dealersPoints > BUST) {
                        didWin = "the dealer bust, you won";
                        win = true;
                        wallet += bet;
                    } else if (playersPoints > BUST) {
                        didWin = "you bust";
                        wallet -= bet;
                    } else if (playersPoints == dealersPoints) {
                        didWin = "you tied";
                        wallet -= bet;
                    } else if (playersPoints > dealersPoints) {
                        didWin = "you won";
                        win = true;
                        wallet += bet;
                    } else {
                        didWin = "you lost";
                        wallet -= bet;
                    }

                    // Output the results from the round and current money
                    System.out.print(name + ", your cards are\n" + playersCards + "\nand the dealer's cards are\n" + dealersCards + "\nYou had " + playersPoints + " points and the dealer had " + dealersPoints + " points. Therefor " + didWin + ".\nYou move " + bet + " spaces ");
                    if(win){
                    	System.out.print("forward.");
                    	return bet;
                    }else{
                    	System.out.print("backward.");
                    	return 0 - bet;
                    }

                    // Find out if they want to play again
                   

                
               
            
        
    }

   

    private static int getHitNoDD() {
        // Find out if they hit when they can't Double Down
        Scanner keyboard = new Scanner(System.in);
        String answer = "";

        boolean invalidInput = true;

        // Are they inputing correctly?
        while (invalidInput) {
            System.out.println("Do you want to 1. Hit or 2. Stay? (Insert Number)");
            answer = keyboard.nextLine();
            for (int i = 0; i < answer.length(); i++) {
                if (answer.length() > 1) {
                    invalidInput = true;
                    i += answer.length();
                    System.out.println("I don't think so!\n");
                } else {
                    if (answer.substring(i, i + 1).equals("1") || answer.substring(i, i + 1).equals("2")) {
                        invalidInput = false;
                    } else {
                        invalidInput = true;
                        System.out.println("I don't think so!\n");
                        i += answer.length();
                    }
                }
            }
        }
        int answerInt = Integer.parseInt(answer);
        return answerInt;
    }
    private static int getHit() {
        // Find out if they hit when they can Double Down
        Scanner keyboard = new Scanner(System.in);
        String answer = "";

        boolean invalidInput = true;

        // Are they inputing correctly?
        while (invalidInput) {
            System.out
                .println("Do you want to 1. Hit 2. Stay or 3. Double Down? (Insert Number)");
            answer = keyboard.nextLine();
            for (int i = 0; i < answer.length(); i++) {
                if (answer.length() > 1) {
                    invalidInput = true;
                    i += answer.length();
                    System.out.println("I don't think so!\n");
                } else {
                    if (answer.substring(i, i + 1).equals("1") || answer.substring(i, i + 1).equals("2") || answer.substring(i, i + 1).equals("3")) {
                        invalidInput = false;
                    } else {
                        invalidInput = true;
                        i += answer.length();
                        System.out.println("I don't think so!\n");
                    }
                }
            }
        }

        int answerInt = Integer.parseInt(answer);
        return answerInt;

    }

    private static int getBet(int wallet, String name) {
        // Find out what they want to bet
        
        Scanner keyboard = new Scanner(System.in);
        boolean invalidInput = true;
        String bet = "";
        boolean invalidInput1 = true;
        while (invalidInput1) {

            // Are they inputing correctly?
            while (invalidInput) {
                System.out.println("How many spaces do you want to gamble?");
                bet = keyboard.nextLine();
                for (int i = 0; i < bet.length(); i++) {
                    if (bet.substring(i, i + 1).equals("0") || bet.substring(i, i + 1).equals("1") || bet.substring(i, i + 1).equals("2") || bet.substring(i, i + 1).equals("3") || bet.substring(i, i + 1).equals("4") || bet.substring(i, i + 1).equals("5")) {
                        invalidInput = false;
                    } else {
                        invalidInput = true;
                        i += bet.length();
                        System.out.println("I don't think so!\n");
                    }
                }
            }

            if (bet.equals("0")) {
                invalidInput1 = true;
                invalidInput = true;
                System.out.println("I don't think so!\n");
            } else if (Integer.parseInt(bet) > wallet) {
                invalidInput1 = true;
                invalidInput = true;
                System.out.println("I don't think so!\n");
            } else {
                invalidInput1 = false;

            }

        }
        // Pass answer as int
        int bet1 = Integer.parseInt(bet);
        return bet1;

    }

  
    private static String getUserName() {
        // Gets players name
        boolean invalidInput = true;
        String name = "";
        while (invalidInput) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What is your first name?");
            name = keyboard.nextLine();
            if (name.equals("")) {
                invalidInput = true;
                System.out.println("I don't think so!\n");
            } else {
                invalidInput = false;
            }
        }
        return name;
    }

}