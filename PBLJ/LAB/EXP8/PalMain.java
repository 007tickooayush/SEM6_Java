package PBLJ.LAB.EXP8;

import java.io.PrintStream;

class Palindrome {
    private final String str;
    private final int len;

    Palindrome(String str) {
        this.str = str.toLowerCase();
        len = str.length();
    }

    boolean checkPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();

        return str.equals(sb.toString());
    }

    String getPalindrome() {
        int spaces = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ')
                spaces++;
        }

        String[] words = str.split(" ");

        if (spaces > 0) {
            int n = words.length;
            int longest = 0, currLen = 0,longestLength=0;

            for (int i = 0; i < n; i++) {
                currLen= words[i].length();
                if (checkPalindrome(words[i]) && currLen > longestLength) {
                    longest = i;
                    longestLength = words[i].length();
                }
            }

            return words[longest];
        } else {
            if (checkPalindrome(str))
                return str;
            else
                return "Not a palindrome";
        }
    }
}

public class PalMain {

    public static void main(String[] args) {
        PrintStream p = new PrintStream(System.out);

        String str = "1234321 racecar otto";

        Palindrome pal = new Palindrome(str);

        p.println(pal.getPalindrome());
        p.close();
    }
}
