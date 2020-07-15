package javaPracticing;

import java.math.BigInteger;
import java.util.*;

public class Application {
    static Long nowTime;
    static Long takenTime_1 =0L;
    static Long takenTime_2 =0L;
    static Long takenTime_3 =0L;
    static Long takenTime_4 =0L;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Set<MyClass> set = new HashSet<MyClass>();

        MyClass my1 = new MyClass("hi");
        MyClass my2 = new MyClass("hi");
        MyClass my3 = new MyClass("hello");

        set.add(my1);
        set.add(my2);
        set.add(my3);

        for(MyClass c : set){
            System.out.println(c.data + " "+ c.hashCode());
        }

        List<MyClass> list = new LinkedList<>(set);

        Collections.sort(list);

        for(MyClass c : list){
            System.out.println(c.data + " "+ c.hashCode());
        }

        Collections.sort(list, Collections.reverseOrder());

        for(MyClass c : list){
            System.out.println(c.data + " "+ c.hashCode());
        }

        Collections.sort(list, new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return 0;
            }
        });
    }
}

class MyClass implements Comparable{
    String data;
    public MyClass(String string){this.data =string;}

    int hashFunction(String data){
        int hash=0;
        for(char c : data.toCharArray()){ hash += c; }
        return hash;
    }

    public int hashCode(){
        return hashFunction(this.data);
    }

    public boolean equals(Object o){
        if(o instanceof MyClass){
            return this.hashCode() == o.hashCode(); }

        else{ return false; }
    }

    public int compareTo(Object o){
        int result =0;

        if(o instanceof MyClass){
            result = o.hashCode() > this.hashCode() ? -1 : 1;
        }

        return result;
    }
}
