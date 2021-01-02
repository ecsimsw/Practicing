package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11055_동적계획법_가장큰증가부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] strs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] < dp[j] + arr[i] && arr[j] < arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.print(max);
    }
}
//11
//1 100 2 50 97 60 98 7 8 9 10