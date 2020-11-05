package javaPracticing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Application {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.addFirst(5);
        list.set(3,5);
        if(br.readLine().equals("a")){
            list.add(5);
        }
        Collections.sort(list);

        Integer[] arr = list.toArray(new Integer[10]);

        Integer[] arr_ = new Integer[]{1,5,6,74,5};

        List list_ = new LinkedList(Arrays.asList(arr));

        list_.add(1);

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
