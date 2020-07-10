package javaPracticing;

import java.math.BigInteger;
import java.util.ArrayList;

public class Application {
    static Long nowTime;
    static Long takenTime_1 =0L;
    static Long takenTime_2 =0L;
    static Long takenTime_3 =0L;
    static Long takenTime_4 =0L;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n =0;

        n =5000;
        nowTime = System.currentTimeMillis();
        printPR(n);
        takenTime_1 = System.currentTimeMillis() - nowTime;

        n =5000;
        sb.delete(0, sb.length());
        nowTime = System.currentTimeMillis();
        printSB(n);
        System.out.println(sb);
        takenTime_2 = System.currentTimeMillis() - nowTime;

        n= 5000;
        nowTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            System.out.print("from 1 to 2 \n");
        takenTime_3 = System.currentTimeMillis() - nowTime;

        n=5000;
        sb.delete(0, sb.length());
        nowTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            sb.append("from 1 to 2 \n");
        System.out.println(sb);
        takenTime_4 = System.currentTimeMillis() - nowTime;

        System.out.println(takenTime_1);
        System.out.println(takenTime_2);
        System.out.println(takenTime_3);
        System.out.println(takenTime_4);
    }

    static void printPR(int i){
        System.out.print(i+ " from 1 to 2 \n");
        if(i==0){ return; }
        printPR(i-1);
    }

    static void printSB(int i){
        sb.append(i + " from 1 to 2 \n");
        if(i==0){ return; }
        printSB(i-1);
    }
}
