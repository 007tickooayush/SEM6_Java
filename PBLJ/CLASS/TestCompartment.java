package PBLJ.CLASS;

/*
 * Create an abstract class Compartment to represent a rail coach. Provide an abstract
 * function notice in this class. Derive FirstClass, Ladies, General, Luggage classes
 * from the compartment class. Override the notice function in each of them to print notice
 * suitable to the type of the compartment.
 * Create a class TestCompartment . Write main function to do the following:
 * Declare an array of Compartment of size 10.
 * Create a compartment of a type as decided by a randomly generated integer in the range 1 to 4.
 * Check the polymorphic behavior of the notice method.
 * */

import java.util.Random;

abstract class Compartment{
    abstract void notice();
}

class FirstClass extends Compartment{

    @Override
    void notice() {
        System.out.println("First Class notice");
    }
}

class Ladies extends Compartment{

    @Override
    void notice() {
        System.out.println("Ladies Class notice");
    }
}

class General extends Compartment{

    @Override
    void notice() {
        System.out.println("General Class notice");
    }
}

class Luggage extends Compartment{

    @Override
    void notice() {
        System.out.println("Luggage Class notice");
    }
}

public class TestCompartment {
    Compartment compartment;

    int choice=0;

    void generate(){
        Random random =new Random();

        for(int i=0;i<10;i++){
            choice = random.nextInt(5);

            if(choice == 1)
                compartment = new General();
            if(choice == 2)
                compartment = new Ladies();
            if(choice == 3)
                compartment = new FirstClass();
            if(choice == 4)
                compartment = new Luggage();


            compartment.notice();
        }

    }
    public static void main(String[] args) {
        TestCompartment test = new TestCompartment();
        test.generate();
    }
}

