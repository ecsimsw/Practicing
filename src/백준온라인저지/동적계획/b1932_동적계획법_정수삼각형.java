package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1932_동적계획법_정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n];

        int cnt =1;
        for(int i=1; i<=n; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=0; j<cnt;j++){
                board[i][j] = Integer.parseInt(nums[j]);
            }
            cnt++;
        }

        dpBoard = new int[n+1][n];

        dp(1,0);

        System.out.println(dpBoard[1][0]);
    }

    static int[][] dpBoard;
    static int[][] board;
    static int n;

    static int dp(int s, int g){
        if(s == n){
            dpBoard[s][g] = board[s][g];
            return dpBoard[s][g];
        }

        if(dpBoard[s][g] != 0){
            return dpBoard[s][g];
        }

        int r = Math.max(dp(s+1, g), dp(s+1,g+1))+board[s][g];
        dpBoard[s][g] = r;

        return r;
    }

}