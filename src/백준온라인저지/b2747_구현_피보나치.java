package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2747_구현_피보나치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        arr = new int[46];

        Arrays.fill(arr, -1);

        arr[0] = 0;
        arr[1] = 1;

        fib(n);

        System.out.println(arr[n]);

    }

    static int[] arr;
    static int fib(int i){
        if(arr[i] != -1) return arr[i];
        arr[i] = fib(i-1) + fib(i-2);
        return arr[i];
    }
}
