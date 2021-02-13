import java.util.*;
import java.io.*;
public class Deck {
    private int[] cards;
    public int lastCard = 51;

    public Deck() {
        cards = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i;
        }
    }

    public static String cardToString(int x) {
        String d = "";
        if (x%13 == 0) {
            d = "K" + (char)(x/13+3) + " ";
        }
        else if (x%13 == 11) {
            d = "J" + (char)(x/13+3) + " ";
        }
        else if (x%13 == 12) {
            d = "Q" + (char)(x/13+3) + " ";
        }
        else if (x%13 == 1) {
            d = "A" + (char)(x/13+3) + " ";
        }
        else {
            d = x%13 + "" + (char)(x/13+3) + " ";
        }
        return d;
    }

    public static int cardToValue (int x) {
        int value = 0;
        if (x%13==0 || x%13==11 || x%13==10 || x%13 == 12){
            value = 10;
        }
        else if (x%13==1){
            value = 11;
        }
        else if (x%13>=1){
            value = x%13;
        }
        return value;
    }

    public void shuffle() {
        int temp;
        for (int i = 0; i < 150; i++) {
            int r1 = (int)(Math.random() * 52);
            int r2 = (int)(Math.random() * 52);
            temp = cards[r1];
            cards[r1] = cards[r2];
            cards[r2] = temp;
        }
    }

    public void display() {
        for (int i = 0; i <= lastCard; i++){
            System.out.print(cardToString(cards[i]) + " ");
        }
    }

    public int giveACard() {
        return cards[lastCard--];
    }



}