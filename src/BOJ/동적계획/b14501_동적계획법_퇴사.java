package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class b14501_동적계획법_퇴사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N];
        int max = 0;
        
        for (int i = 1; i <=N; i++) {
            String[] str = br.readLine().split(" ");
            T[i] = Integer.parseInt(str[0]);
            P[i] = Integer.parseInt(str[1]);
        }
        for (int i = 1; i <=N+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[T[i]+i] = Math.max(dp[T[i]+i],P[i]+dp[i]);
            max = Math.max(max, dp[i]);

        }
        System.out.println(max);
    }
}
