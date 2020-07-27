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
        String line ="\"$MSE\"{\"1안녕하세요\"}\"$MSE\"{\"2안녕하세요\"}\"$MSE\"{\"3안녕하세요\"}";
        List<String> strings = new ArrayList<>();

        StringBuilder sb = new StringBuilder(line);
        int from=0, to =0;

        while(true) {
            from = sb.indexOf("\"$MSE", to);
            to = sb.indexOf("\"$MSE", from+1);
            if(to == -1 ){
                strings.add(sb.substring(from,sb.length()));
                break;
            }
            strings.add(sb.substring(from,to));
        }

        for(String s : strings) System.out.println(s);
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
