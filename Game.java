import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

public class Game {
    Player user;
    Dealer dealer;
    String name;
    Deck deck;

    Scanner sc = new Scanner(System.in);

    public void playGame(){
        deck = new Deck();

        System.out.print("\n");
        System.out.print("Original Deck: ");
        System.out.print("\n");
        deck.display();

        deck.shuffle();
        System.out.print("\n\n");

        System.out.print("Shuffled Deck: ");
        System.out.print("\n");
        deck.display();

        System.out.print("\n\n");
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        user = new Player(name);
        System.out.print("Welcome " + name + ".");

        while (user.keepGoing()) {
            user = new Player(name);
            dealer = new Dealer();

            int card = deck.giveACard();
            user.takeACard(card);

            if (deck.lastCard < 10) {
                deck = new Deck();
                deck.shuffle();
            }

            card = deck.giveACard();
            user.takeACard(card);
            user.showHands();
            System.out.print("\n");

            card = deck.giveACard();
            dealer.takeACard(card);

            card = deck.giveACard();
            dealer.takeACard(card);
            dealer.showHands();
            System.out.print("\n");


            while (user.checkScore() && dealer.checkScore()) {
                if (!user.playerChoice()) {
                    while (dealer.dealerGoing()) {
                        card = deck.giveACard();
                        dealer.takeACard(card);
                        dealer.showHands();
                        System.out.print("\n");
                    }
                    if (!user.checkScore() || dealer.playerTotal() == 21 || (user.playerTotal() < dealer.playerTotal() && dealer.playerTotal() <= 21)) {
                        dealer.showAllHands();
                        System.out.print("\n\nThe dealer WON!\n\n");
                        deck.display();
                    }
                    else if (!dealer.checkScore() || user.playerTotal() == 21 || (user.playerTotal() > dealer.playerTotal() && user.playerTotal() <= 21)) {
                        dealer.showAllHands();
                        System.out.print("\n\nYou WON!\n\n");
                        deck.display();
                    }
                    else if (user.playerTotal() == dealer.playerTotal() && user.playerTotal() < 21 && dealer.playerTotal() < 21) {
                        dealer.showAllHands();
                        System.out.print("\n\nIt's a TIE!\n\n");
                        deck.display();
                    }
                    else {
                        dealer.showAllHands();
                        System.out.print("\n\nThe dealer WON!\n\n");
                        deck.display();
                    }
                    break;
                }
                else {
                    card = deck.giveACard();
                    user.takeACard(card);
                    user.showHands();
                    System.out.print("\n\n");
                    if (!user.checkScore()) {
                        System.out.print("\n");
                        dealer.showAllHands();
                        System.out.print("\n\nThe dealer WON!\n\n");
                        deck.display();
                    }
                }
            }
        }
    }


}