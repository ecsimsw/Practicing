package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11052_동적계획법_카드구매 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n+1];

        String[] strs = br.readLine().split(" ");

        for(int i=1; i<=n; i++){
            board[i] = Integer.parseInt(strs[i-1]);
        }

        int[] dp = new int[n+1];

        dp[1] = board[1];

        for(int index =2; index<=n; index++){

            int max=0;
            int left =1;
            int right = index-1;

            while(left<=right){
                max = Math.max(max, dp[left] +dp[right]);
                left++; right--;
            }

            dp[index] = Math.max(max, board[index]);
        }

        System.out.print(dp[n]);
    }
}
