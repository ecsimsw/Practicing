package BOJ.동적계획;

import java.io.*;
import java.util.*;

public class b9465_동적계획법_스티커{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        String[] nums;

        for(int l=0; l<loop; l++){
            n = Integer.parseInt(br.readLine());
            board = new int[n][3];
            dp = new int[n][3];

            nums = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                board[i][0] = Integer.parseInt(nums[i]);
            }

            nums = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                board[i][1] = Integer.parseInt(nums[i]);
            }

            dp();

            int max = Math.max(Math.max(dp[n-1][0], dp[n-1][1]),dp[n-1][2]);
            sb.append(max+"\n");
        }

        System.out.print(sb.toString());
    }

    static int[][] board;
    static int n;
    static int[][] dp;

    static void dp(){
        dp[0][0] = board[0][0];
        dp[0][1] = board[0][1];
        dp[0][2] = 0;

        for(int index=1; index<n; index++){
            int chooseFirst = Math.max(dp[index-1][1] + board[index][0], dp[index-1][2]+ board[index][0]);
            int chooseSecond = Math.max(dp[index-1][0] + board[index][1], dp[index-1][2]+ board[index][1]);
            int chooseNone = Math.max(dp[index-1][0], dp[index-1][1]);

            dp[index][0] = chooseFirst;
            dp[index][1] = chooseSecond;
            dp[index][2] = chooseNone;
        }
    }
}
