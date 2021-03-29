package PBLJ.LAB.EXP6;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StringList {
    List<String> stringList;
    int size;

    StringList() {
        stringList = new ArrayList<>();
        new StringList(13);
    }

    StringList(int size) {
        this.size = size;
        stringList = new ArrayList<>(size);
    }

    void prompt() {
        PrintStream p = new PrintStream(System.out);
        Scanner s = new Scanner(System.in);


        int choice = 1;
        while (choice != 5 && choice > 0 && choice < 6) {
            p.print("Enter task to do: \n");
            p.format("|1. %-10s |\n", "INSERT");
            p.format("|2. %-10s |\n", "SEARCH");
            p.format("|3. %-10s |\n", "DELETE");
            p.format("|4. %-10s |\n", "DISPLAY");
            p.format("|5. %-10s |\n", "EXIT");

            choice = s.nextInt();
            String str;
            switch (choice) {
                case 1:
                    p.print("--ENTER VALUE TO INSERT : ");
                    str = s.next();

                    stringList.add(str);

                    if (stringList.contains(str))
                        p.println("--INSERTION SUCCESSFUL--");
                    break;
                case 2:
                    p.print("--ENTER ELEMENT TO SEARCH: ");
                    str = s.next();
                    if (stringList.contains(str)) {
                        p.println("--ELEMENT FOUND--");
                        p.format("--INDEX: %d\n", stringList.indexOf(str));
                    }else
                        p.println("--ELEMENT NOT FOUND--");

                    break;
                case 3:
                    p.print("--ENTER ELEMENT TO REMOVE : ");
                    str = s.next();
                    stringList.remove(str);

                    if(!stringList.contains(str))
                        p.println("--DELETION SUCCESSFUL--");

                    break;
                case 4:
                    String list = stringList.toString().replaceAll("]","").replaceAll("\\[","");
                    p.format("--ELEMENTS: %s",list);
                    break;
                case 5:
                    stringList.clear();
                    p.println("--TERMINATED--");
                    break;
                default:
                    p.println("--TERMINATED--");
                    break;
            }
            p.println();
        }
        s.close();
        p.close();
    }

}

public class ListMain {
    public static void main(String[] args) {
        StringList s = new StringList();

        s.prompt();
    }
}
