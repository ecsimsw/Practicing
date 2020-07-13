package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10872_재귀_팩토리얼 {
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(fact(n));
    }
    static int fact(int n){
        if(n==0) return 1;
        if(n == 1) return 1;
        return n * fact(n-1);
    }
}

