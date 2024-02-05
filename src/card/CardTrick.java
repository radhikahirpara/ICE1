package card;

import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Radhika Hirpara
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            int userValue = 0;
            int userSuit = 0;
            Card c = new Card(userValue, Card.SUITS[userSuit]);
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
        }
        
        // Ask the user for a card and search the magic hand
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0 = Hearts, 1 = Diamonds, 2 = Clubs, 3 = Spades): ");
        int userSuit = scanner.nextInt();
        Card userCard = new Card(userValue, Card.SUITS[userSuit]);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit() == userCard.getSuit()) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Add a hardcoded "luck card"
        Card luckCard = new Card(2, "Clubs");
        System.out.println("There is also a luck card in the magic hand: " + luckCard);
    }
}
