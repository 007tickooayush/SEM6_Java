package PBLJ.LAB.MST1.com.automobile.TwoWheeler;

import PBLJ.LAB.MST1.com.automobile.Vehicle;

import java.io.PrintStream;
import java.util.Scanner;

class Hero extends Vehicle{
    boolean radio = false;
    @Override
    public String getModelName() {
        return "Hero";
    }

    @Override
    public String getRegistrationNumber() {
        return "PB 65 K 7O21";
    }

    @Override
    public String getOwnerName() {
        return "Ayush";
    }

    public int getSpeed(){
        return 90;
    }

    public void radio(){
        radio = true;
    }
}

class Honda extends Vehicle{
    boolean cdPlayer;
    @Override
    public String getModelName() {
        return "Honda";
    }

    @Override
    public String getRegistrationNumber() {
        return "PB 65 K 9081";
    }

    @Override
    public String getOwnerName() {
        return "Ayush Tickoo";
    }

    public int getSpeed(){
        return 80;
    }

    public void cdPlayer(){
        cdPlayer = true;
    }
}

public class TwoWheeler {
    static final PrintStream p = new PrintStream(System.out);
    static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {


        Vehicle bike;
        bike = new Hero();

        p.println("Class: "+bike.getClass().getSimpleName());
        p.println("Speed: "+((Hero) bike).getSpeed());
        ((Hero) bike).radio();
        if(((Hero)bike).radio)
            p.println("Radio on");

        bike = new Honda();
        p.println("Class: "+bike.getClass().getSimpleName());
        p.println(((Honda)bike).getSpeed());
        ((Honda)bike).cdPlayer();
        if(((Honda)bike).cdPlayer)
            p.println("CD Player on");

    }
}
