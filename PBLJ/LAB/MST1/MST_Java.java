package PBLJ.LAB.MST1;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Question1{
    static final Scanner s = new Scanner(System.in);
    static final PrintStream p = new PrintStream(System.out);
    void doQues(){

        int []arr = {1,33,45,67};
        int find = 45;
        int index =0;
        boolean present = false;
        for(int i:arr){
            if(i == find){
                present = true;
                break;
            }
            index++;
        }

        if(present)
            p.println(index);
        else
            p.println(-1);
    }
}


public class MST_Java {
    public static void main(String[] args) {

        Question1 qq = new Question1();
        qq.doQues();

    }
}
