package javaPracticing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 10;
        int y = 20;

//        MyClass x = new MyClass(10);
//        MyClass y = new MyClass(20);

        int[] swapR = swap(x, y);

        x = swapR[0];
        y = swapR[1];

        System.out.println(x + " "+y);
    }

    static int[] swap(int x, int  y){
        int temp = x;
        x = y;
        y = temp;

        int[] r = new int[2];
        r[0] = x;
        r[1] = y;

        return r;
    }
}

class MyClass{
    public int value;

    public MyClass(int x){
        value = x;
    }
}
