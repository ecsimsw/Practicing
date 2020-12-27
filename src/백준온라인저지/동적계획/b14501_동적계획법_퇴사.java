package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class b14501_동적계획법_퇴사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board_T = new int[n+1];
        board_P = new int[n+1];
        String[] line;
        for(int i =1; i<=n; i++){
            line = br.readLine().split(" ");
            board_T[i] = Integer.parseInt(line[0]);
            board_P[i] = Integer.parseInt(line[1]);
        }

        dp = new int[n+1];

        for(int i=0; i<n+1; i++){
            dp[i] = -1;
        }

        dp(1);

        int max = 0;
        for(int i : dp){
            if(i> max) max = i;
        }
        System.out.print(max);
    }

    static int n;

    static int[] board_T;
    static int[] board_P;
    static int[] dp;

    static int dp(int day){
        if(day > n) {
            System.out.println("day: " + day);
            return 0;
        }

        if(dp[day]!=-1) { return dp[day]; }

        if(board_T[day]+day-1 > n){
            dp[day] = dp(day+1);
            return dp(day+1);
        }

        dp[day] = Math.max(board_P[day]+dp(day+board_T[day]), dp(day+1));

        return dp[day];
    }
}

class b14501_동적계획법_퇴사_ {
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
