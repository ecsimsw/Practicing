package javaPracticing;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();

        FruitBox<Apple> appleBox = new FruitBox<>();

        appleBox.add(apple1);
        appleBox.add(apple2);

        System.out.println(Juicer.makeJuice(appleBox));
    }
}
class Juice{}

class Juicer{
    static <T extends Fruit> String makeJuice(FruitBox<T> box){
        String tmp = "";
        for(Fruit f : box.list){tmp +="apple  / ";}
        tmp+="juice";
        return tmp;
    }
}

class Fruit{ }
class Apple extends Fruit{}

class FruitBox<T extends Fruit> extends Box<T> {}

class Box<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item){list.add(item);}
    T get(int i){return list.get(i);}
}

/*
class Card<T>{
    T cardNumber;

    public Card(T cardNumber){
        this.cardNumber = cardNumber;
    }
}
class Student {
    public void tagCard(Card<?> card) {
        String a = card.cardNumber.toString();
        a += "123";
        System.out.println(card.cardNumber);
    }
}

 */