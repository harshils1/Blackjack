import java.util.*;
import java.io.*;
public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public void showHands(){
        System.out.print("\nThe dealer's hand is: ");
        System.out.print(deck.cardToString(hands[0]));
        for (int i = 1; i < numCards; i++) {
            System.out.print("?" + " ");
        }
    }

    public void showAllHands() {
        super.showHands();
    }

    public boolean dealerGoing() {
        if (super.playerTotal() < 16)
            return true;
        else
            return false;
    }
}