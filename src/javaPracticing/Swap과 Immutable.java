package javaPracticing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

class App1 {
    public static void main(String[] args){
       MyClass a = new MyClass(10);
       MyClass b = new MyClass(20);

       swap(a,b);

       System.out.println(a.value +" "+ b.value);
    }

    static void swap(int x, int  y){
        int temp =x;
        x =y;
        y =temp;
    }

    static void swap(MyClass x, MyClass y){
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }
}

class MyClass{
    public Integer value;

    public MyClass(int x){
        value = x;
    }
}


class App2 {
    public static void main(String[] args) throws Exception{

        Integer i = 10;

        changeInteger(i);

        System.out.println(i);
//
//        MyClass myClass = new MyClass(10);
//
//        changeClass(myClass);
//
//        System.out.println(myClass.value);
    }

    static void changeClass(MyClass a){
        a.value = 20;
    }
    static void changeInteger(Integer a){
        a = 20;
    }
}


