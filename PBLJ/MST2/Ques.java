package PBLJ.MST2;

import java.io.*;

public class Ques {

    public static void main(String[] args) {
        File file = new File("D:\\91374\\Excercism\\PRs\\java\\SEM6\\src\\PBLJ\\MST2\\demo.txt");
        try {

            int count=0;

            char see = 'r';
            int f = 0;

            BufferedReader bf = new BufferedReader(new FileReader(file));

            while(f != -1){
                f = bf.read();

                if(f>=65 && f<=90)
                        f+=32;

                if(f == see)
                    count++;
            }

            bf.close();

            System.out.println("File "+file+" has "+count+" instances of  letter '"+see+"'.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}