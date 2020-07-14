package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b9663_백트래킹_NQueen {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new int[n];
        row = new boolean[n];
        board = new boolean[n][n];

        int r =func(0);
        System.out.println(r);
    }

    static int n;
    static boolean[] row;
    static int[] col;
    static boolean[][] board;

    static int func(int c){
        if(c == n) return 1;

        int result =0;

        for(int r =0; r<n; r++){
            if(checker(c, r)){
                col[c] = r;
                row[r] = true;
                board[c][r] = true;
                result+=func(c+1);
                row[r] = false;
                board[c][r] = false;
            }
        }

        return result;
    }

    static boolean checker(int s, int g){
        if(row[g]) return false;

        int i =1;
        // 왼쪽 위
        while(true) {
            if(s-i<0 || g-i<0) break;
            if(col[s-i] == g-i) return false;
            i++;
        }

        i =1;
        // 오른쪽 위
        while(true) {
            if(s-i<0 || g+i >=n ) break;
            if(col[s-i] == g+i) return false;
            i++;
        }

        return true;
    }
}
