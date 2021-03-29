package PBLJ.LAB.EXP5;

import javafx.util.Pair;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Cards {
    HashSet<Integer> number;
    HashSet<String> symbol;
    ArrayList<Pair<String,Integer>> cards;
    Integer unique;

    Scanner s = new Scanner(System.in);
    PrintStream p = new PrintStream(System.out);

    Cards() {
        symbol = new HashSet<>();
        number = new HashSet<>();
        cards = new ArrayList<>();
        unique = 0;
    }

    void getCards() {
        p.print("Enter number of cards: ");
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            p.format("Enter card %d:\n", i + 1);
            String symbol = s.next();
            int num = s.nextInt();

            if (!this.symbol.contains(symbol)) {
                unique++;
                cards.add(new Pair<String,Integer>(symbol,num));
            }

            this.symbol.add(symbol);
            this.number.add(num);
        }
        p.println(unique + " symbols added in " + n + " cards.");

    }

    void printCards() {
        p.println("Cards in set are: ");
        for(Pair<String,Integer> card:cards){
            p.println(card.getKey()+" "+card.getValue());
        }
    }
}

public class CardsMain {
    public static void main(String[] args) {
        Cards cards = new Cards();

        cards.getCards();
        cards.printCards();

    }
}
