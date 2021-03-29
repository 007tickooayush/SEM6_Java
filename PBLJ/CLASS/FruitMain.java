package PBLJ.CLASS;

//Create a base class Fruit which has name ,taste and size as its attributes.
// A method called eat() is created which describes the name of the fruit and its taste.
// Inherit the same in 2 other class Apple and Orange and override the eat() method to represent each fruit taste.

abstract class Fruit{
    String name;
    String taste;
    void eat(){ }
}

class Apple extends Fruit{
    @Override
    void eat() {

        name = "Apple";
        taste = "sweet";

        System.out.println("Fruit name:"+name);

        System.out.println("Fruit taste:"+taste);
        System.out.println();
    }
}

class Orange extends Fruit{
    @Override
    void eat() {

        name = "Orange";
        taste = "sour";

        System.out.println("Fruit name:"+name);

        System.out.println("Fruit taste:"+taste);
        System.out.println();
    }
}

public class FruitMain {

    public static void main(String[] args) {
        Fruit fruit = new Apple();
        fruit.eat();

        fruit = new Orange();
        fruit.eat();
    }
}
