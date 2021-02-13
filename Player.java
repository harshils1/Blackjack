import java.util.*;
import java.io.*;
public class Player {
    protected String name;
    protected int[] hands;
    protected int numCards;
    protected int total;
    protected Scanner choice;
    protected Deck deck = new Deck();

    public Player(String n) {
        this.name = n;
        this.hands = new int[8];
        this.numCards = 0;
    }

    public void takeACard(int c) {
        hands[numCards++] = c;
    }

    public void showHands() {
        System.out.print("\n" + name + "'s hand is: ");
        for (int i = 0; i < numCards; i++) {
            System.out.print(deck.cardToString(hands[i]));
        }
        System.out.print("\nThe value is: " + playerTotal());
    }

    public int playerTotal() {
        total = 0;
        for (int i = 0; i < numCards; i++) {
            if (deck.cardToString(hands[i]).indexOf("A") != -1 && 21 - total <= 10)
                total += deck.cardToValue(hands[i]) - 10;
            else
                total += deck.cardToValue(hands[i]);
        }
        return total;
    }

    public boolean playerChoice(){
        choice = new Scanner(System.in);
        String userChoice = "";
        boolean cont = true;
        boolean out = false;
        while (cont) {
            System.out.print("\nDo you want to HIT? [Y/N]: ");
            userChoice = choice.nextLine().trim().toUpperCase();
            if (userChoice.equals("Y")) {
                cont = false;
                out = true;
            }
            else if (userChoice.equals("N")) {
                cont = false;
                out = false;
            }
            else {
                cont = true;
                out = false;
            }
        }
        return out;
    }

    public boolean checkScore() {
        if (playerTotal() <= 21)
            return true;
        else
            return false;
    }

    public boolean keepGoing() {
        choice = new Scanner(System.in);
        String userChoice = "";
        boolean going = false;
        boolean cont = true;
        while (cont) {
            System.out.print("\n\nWould you like to play Blackjack? [Y/N]: ");
            userChoice = choice.nextLine().trim().toUpperCase();
            if (userChoice.equals("Y")) {
                cont = false;
                going = true;
            }
            else if (userChoice.equals("N")) {
                cont = false;
                going = false;
            }
            else {
                cont = true;
                going = false;
            }
        }
        return going;
    }

}