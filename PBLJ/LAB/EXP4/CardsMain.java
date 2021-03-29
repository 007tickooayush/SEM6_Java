package PBLJ.LAB.EXP4;

import javafx.util.Pair;

import java.io.PrintStream;
import java.util.*;


class CustomHash {
    private final PrintStream print = new PrintStream(System.out);
    private final Scanner scan = new Scanner(System.in);
    private ArrayList<Pair<String, Integer>> map;
    private Integer added = 0, size;
    private ArrayList<String> distinctKey;
    int distinctInitialCapacity = 1, distinctCurrentCapacity = 0;

    CustomHash() {

    }

    CustomHash(int size) {
        this.size = size;
        map = new ArrayList<>(size);
        distinctKey = new ArrayList<>(distinctInitialCapacity);

    }

    int getSize() {
        return map.size();
    }

    void addElement(String key, Integer val) {

        if (!distinctKey.contains(key)) {
            distinctKey.add(key);
            distinctCurrentCapacity++;
        }
        this.size = map.size();
        map.add(added, new Pair<>(key, val));
        added++;
    }

    void printDistinct(){
        print.println(distinctKey);
    }

    ArrayList<String> getDistinct(){
        return distinctKey;
    }
    void printHash() {
        print.println(map);
    }

    ArrayList<Pair<String, Integer>> getMap(){
        return map;
    }

    int getCount(String k) {
        int count = 0;
        for (int i = 0; i < added; i++) {
            if (map.get(i).getKey().equals(k)) {
                count++;
            }
        }
        return count;
    }

    int getSum(String k){
        int sum=0;
        for(int i=0;i<added;i++){
            if(map.get(i).getKey().equalsIgnoreCase(k)){
                sum+=map.get(i).getValue();
            }
        }
        return sum;
    }
}

class Cards{
    private final PrintStream print = new PrintStream(System.out);
    private final Scanner scan = new Scanner(System.in);
    CustomHash cards;
    void manageCards(){
        print.print("Enter the number of cards: ");
        int n = scan.nextInt();
        cards = new CustomHash(n);

        for(int i=0;i<n;i++){
            print.format("Enter card %d: \n",i+1);
            String card = scan.next();
            Integer cardNum = scan.nextInt();
            cards.addElement(card,cardNum);
        }

        print.print("The distinct cards are: ");
        cards.printDistinct();
        ArrayList<String> uniqueCards = cards.getDistinct();
        for(int i=0;i< cards.distinctCurrentCapacity;i++){
            String card = uniqueCards.get(i);
            int count = cards.getCount(card);
            print.format("Number of cards in %s symbol: %d",card,count);
            print.println();

            int sum = cards.getSum(card);
            print.format("Sum of cards in %s symbol: %d",card,sum);
            print.println();

            print.format("Cards of %s symbol: \n",card);
            ArrayList<Pair<String,Integer>> printingCards = cards.getMap();
            for(int j=0;j<cards.getSize();j++){
                if(printingCards.get(j).getKey().equalsIgnoreCase(card))
                    print.println(printingCards.get(j).getKey() + " "+printingCards.get(j).getValue());
            }

        }
    }

}

public class CardsMain {
    public static void main(String[] args) {

        Cards cards = new Cards();
        cards.manageCards();

    }
}
