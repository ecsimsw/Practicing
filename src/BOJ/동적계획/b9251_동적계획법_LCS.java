package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b9251_동적계획법_LCS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();


        n = str1.length;
        m = str2.length;

        board = new int[n+1][m+1];

        fillBoard();

        System.out.print(board[n][m]);
    }

    static int[][] board;
    static int n;
    static int m;

    static char[] str1;
    static char[] str2;

    static void fillBoard(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1[i-1] != str2[j-1]){
                    board[i][j] = Math.max(board[i][j-1], board[i-1][j]);
                }
                else{
                    board[i][j] = board[i-1][j-1] +1;
                }
            }
        }
    }
}
