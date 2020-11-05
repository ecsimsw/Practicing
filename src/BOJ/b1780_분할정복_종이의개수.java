package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1780_분할정복_종이의개수 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        String[] line;
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<n; j++){ board[i][j] = Integer.parseInt(line[j]); }
        }

        rec(0,0,n);

        System.out.println(count_mo);
        System.out.println(count_ze);
        System.out.println(count_on);
    }

    static void rec(int s, int g, int n){
        int result = allSame(s,g,n);
        if( result != -99){
            if(result == -1){ count_mo++; }
            else if(result == 1){ count_on++; }
            else{ count_ze++; }
            return;
        }

        rec(s, g, n/3);
        rec(s, g+n/3, n/3);
        rec(s, g+2*n/3, n/3);
        rec(s+n/3, g, n/3);
        rec(s+n/3, g+n/3, n/3);
        rec(s+n/3,g+n*2/3, n/3);
        rec(s+n*2/3, g, n/3);
        rec(s+n*2/3, g+n/3, n/3);
        rec(s+n*2/3, g+2*n/3, n/3);
    }

    static int[][] board;

    static int count_mo;
    static int count_ze;
    static int count_on;

    static int allSame(int s, int g, int n){
        int first = board[s][g];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[s+i][g+j] != first){
                    return -99;
                }
            }
        }

        return first;
    }
}
