package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1149_백트래킹_RGB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i=0; i<n; i++){
            String[] num = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                board[i][j] = Integer.parseInt(num[j]);
            }
        }

        dpBoard = new int[n][3];

        dp(0,0);
        dp(0,1);
        dp(0,2);

        System.out.println(Math.min(Math.min(dpBoard[0][0], dpBoard[0][1]),dpBoard[0][2]));
    }

    static int[][] board;
    static int n;
    static int[][] dpBoard;

    static int dp(int level, int choose){

        if(level ==n-1){
            dpBoard[level][choose]  = board[level][choose];
            return board[level][choose];
        }

        if(dpBoard[level][choose]!=0){
            return dpBoard[level][choose];
        }

        int result=0;
        if(choose == 0){
                result = Math.min(dp(level+1,1), dp(level+1, 2)) + board[level][0];
                dpBoard[level][0] = result;
        }
        else if(choose == 1){
            result = Math.min(dp(level+1,2), dp(level+1,0)) + board[level][1];
            dpBoard[level][1] = result;
        }
        else if(choose == 2){
            result = Math.min(dp(level+1,1), dp(level+1, 0)) + board[level][2];
            dpBoard[level][2] = result;
        }
        return result;
    }
}
