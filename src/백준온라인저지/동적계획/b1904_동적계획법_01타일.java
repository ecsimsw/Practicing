package 백준온라인저지.동적계획;

import java.io.*;

public class b1904_동적계획법_01타일 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        if(n<3){
            System.out.print(n);
            return;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%15746;
        }

        System.out.print(dp[n]);
    }
}
