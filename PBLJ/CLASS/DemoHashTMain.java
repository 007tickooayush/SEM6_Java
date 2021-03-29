package PBLJ.CLASS;


import java.util.HashSet;
import java.util.TreeSet;

class Hash{
    HashSet<String> hs;

    Hash(int size){
        hs = new HashSet<>(size);
    }

    Hash(){
        hs = new HashSet<>();
    }

}

public class DemoHashTMain {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("Ayush");
        hs.add("Caterina");
        hs.add("Azul");

        System.out.println(hs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Caterina");
        ts.add("AT");

        System.out.println(ts);
    }
}
