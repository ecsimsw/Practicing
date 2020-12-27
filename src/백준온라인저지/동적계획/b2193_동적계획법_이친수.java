package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2193_동적계획법_이친수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if(n==1 || n==2) {
            System.out.println("1");
            return;
        }

        dpBoard = new long[n][2];
        System.out.println(dp(0,0)+dp(0,1));
    }

    static long[][] dpBoard;
    static int n;

    static long dp(int index, int bi){
        if(dpBoard[index][bi]!=0){
            return dpBoard[index][bi];
        }

        if(index == n-3){
            dpBoard[index][bi]=1;
            return 1;
        }

        long r;
        if(bi == 0) {
            r = dp(index+1, 0)+ dp(index+1,1);

        }
        else{
            r = dp(index+1,0);
        }
        dpBoard[index][bi] = r;
        return r;
    }
}
