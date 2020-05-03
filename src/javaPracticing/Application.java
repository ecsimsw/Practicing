package javaPracticing;

import java.util.*;

public class Application {
    private final String str="";

    public static void main(String[] args) {

        Application.<Integer>getID(123);

    }
    public static <T> T getID(T id){return (T)id;}
}
class Parent{
   static public void sayHi(){
       System.out.println("parent");
   }
}

class Child extends Parent{
    static public void sayHi(){
        System.out.println("child");
    }
}

class Student<T>{
    T name;

    public T getName(T name){ this.name = name; return name; }
    public <S> T toT1(S id){return (T)id;}
    public <T> T getId(T id){return (T)id;}
}
