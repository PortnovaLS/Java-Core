package Lesson3.Fruits;

import javax.swing.*;

public class MainFruit {
    public static void main(String[] args) {

        BoxFruit<Apple> boxApple = new BoxFruit<Apple>();
        BoxFruit<Apple> boxApple2 = new BoxFruit<Apple>();
        BoxFruit<Orange> boxOrange = new BoxFruit<Orange>();
        Apple apple1 = new Apple(1.0f);
        Apple apple2 = new Apple(2.1f);
        Orange orange1 = new Orange(1.5f);
        Orange orange2 = new Orange(2.1f);

        boxApple.addFruit(apple1);
        boxApple.addFruit(apple2);
        boxOrange.addFruit(orange1);
        boxOrange.addFruit(orange2);

        System.out.println("Вес коробки яблок " + boxApple.getWeight());
        System.out.println("Вес коробки апельсинов " + boxOrange.getWeight());

        System.out.println(boxApple.compareBox(boxOrange));

        boxApple.move(boxApple2);


        System.out.println(boxApple2.toString());


    }
}
