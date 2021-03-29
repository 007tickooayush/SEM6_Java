package PBLJ.Customs.Custom1;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

class CustomList<v>{
    private final Object []list;
    private Object [] reverse;
    transient int size = 10;
    private int added;
    CustomList(){
        this.size = 11;
        this.added=0;
        this.list = new Object[size];
        this.reverse = new Object[size];
    }
    CustomList(Integer size){
        this.size = size;
        this.added=0;
        this.list = new Object[size];
    }

    void add(v val){
        list[added++] = val;
    }

    void add(int index,v val){
        this.list[index] = val;
    }
    Object[] getArrayAsArray(){
        return Arrays.copyOf(list,list.length);
    }

    List<Object> getArrayNotNullList(){
        return Arrays.stream(list).filter(Objects::nonNull).collect(Collectors.toList());
    }
    Object[] getArrayAsNotNullArray(){
        return Arrays.stream(list).filter(Objects::nonNull).toArray();
    }

    void remove(int index) {
        if (added - index >= 0) System.arraycopy(list, index + 1, list, index, added - index);
        added--;
    }

    void remove(v val){
        for(int index=0;index<added;index++){
            if(list[index].equals(val)) {
                remove(index);
                break;
            }
        }
        added--;
    }

    int indexOf(v val){
        return Arrays.asList(list).indexOf(val);
    }

    Object[] getReversedArray(){
        //TODO implement return reversed list  function
        return reverse;
    }
}

public class CustomType{

    final static PrintStream p = new PrintStream(System.out);
    final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {


        CustomList<String> l = new CustomList<>(5);
        l.add("Ayu");
        l.add("sh ");
        l.add("Tic");
        l.add("koo");

        p.println(l.indexOf("koo"));

//        p.println(Arrays.toString(l.getArrayAsNotNullArray()));
//        p.println(Arrays.toString(new List[]{l.getArrayNotNullList()}));
//
//
//        p.println();
//        l.add(4,"tic");
//
//
//        for(Object o:l.getArrayNotNullList()){
//            if(o!= null)
//                p.print(o);
//        }
//        p.println();
//
//        l.add(4,"tic");
//        p.println();
//
//        p.println(Arrays.toString(l.getArrayAsArray()));
//
//        l.remove(2);
//        l.remove("Ayu");
//        for(Object o:l.getArrayAsArray()){
//            if(o!= null)
//                p.print(o);
//        }


    }
}
