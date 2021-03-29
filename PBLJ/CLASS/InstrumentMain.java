package PBLJ.CLASS;
//Create an abstract class Instrument which is having the abstract function play.
//Create three more sub classes from Instrument which is Piano, Flute, Guitar.
// Override the play method inside all three classes printing a message
//“Piano is playing tan tan tan tan ” for Piano class
//“Flute is playing toot toot toot toot” for Flute class
//“Guitar is playing tin tin tin ” for Guitar class
//You must not allow the user to declare an object of Instrument class.
//Create an array of 10 Instruments.
//Assign different type of instrument to Instrument reference.
//Check for the polymorphic behavior of play method.
//Use the instanceof operator to print that which object stored at which index of instrument array.

import java.io.PrintStream;

abstract class Instrument{
    PrintStream print = new PrintStream(System.out);
    abstract void play();
}

class Piano extends Instrument{

    @Override
    void play() {
        print.println("toot toot toot");
        print.println();
    }
}

class Flute extends Instrument{

    @Override
    void play() {
        print.println("tan tan tan");
        print.println();
    }
}

class Guitar extends Instrument{

    @Override
    void play() {
        print.println("tin tin tin");
        print.println();
    }
}

public class InstrumentMain {
    public static void main(String[] args) {
        Instrument instrument;

        instrument =  new Piano();
        instrument.play();

        instrument = new Flute();
        instrument.play();

        instrument = new Guitar();
        instrument.play();

    }
}
