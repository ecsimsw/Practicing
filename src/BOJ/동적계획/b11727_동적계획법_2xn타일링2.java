package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11727_동적계획법_2xn타일링2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n =Integer.parseInt(br.readLine());

        if(n==1) {System.out.print("1"); return;}

        dpBoard = new long[n];

        dpBoard[n-1] = 1;
        dpBoard[n-2] = 3;

        for(int i =n-3; i>-1; i--){
            dp(i);
        }

        System.out.print(dpBoard[0]%10007);
    }

    static int n;
    static long[] dpBoard;

    static long dp(int index){
        if(index <= -1) {
            return 0;
        }

        if(dpBoard[index]!=0){
            return dpBoard[index];
        }

        dpBoard[index] = (2*dp(index+2) + dp(index+1))%10007;
        return dpBoard[index];
    }
}
