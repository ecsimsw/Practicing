package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10870_재귀_피보나치수5 {
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Long time = System.currentTimeMillis();
        Arrays.fill(calculated, 0);
        calculated[0] = 0;
        calculated[1] = 1;
        calculated[2] = 1;
        System.out.println(fibo(n));
        System.out.println(System.currentTimeMillis()-time);

        time = System.currentTimeMillis();
        System.out.println(fibo_ori(n));
        System.out.println(System.currentTimeMillis()-time);
    }
    static int[] calculated = new int[1000];

    static int fibo(int n){
        if(n==0) return 0;
        if(calculated[n]!=0) return calculated[n];

        int value = fibo(n-1) + fibo(n-2);
        calculated[n] = value;

        return value;
    }

    static int fibo_ori(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        return fibo_ori(n-1) + fibo_ori(n-2);
    }

}
