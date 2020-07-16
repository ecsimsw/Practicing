package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1018_브루트포스_체스판다시칠하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M;
        int N;

        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        board = new char[M][N];

        for(int s =0; s < M; s++){
            String[] line = br.readLine().split("");
            for(int g =0; g<N; g++) {
                board[s][g] = line[g].charAt(0);
            }
        }

        int max =0;
        for(int s =0; s < M-7; s++){
            for(int g =0; g<N-7; g++){

                int r = cor(s,g);
                if(max < r){
                    max =r;
                }
            }
        }
        System.out.print(64-max);
    }
    static char[][] board;

    static int cor(int s, int g){
        int result_wb =0;
        int result_bw =0;

        char w = 'W';

        for(int i= s; i<s+8; i++){
            for(int j=g; j<g+8; j++){
               if(board[i][j] == w){
                   result_wb++; }
               else{
                   result_bw++; }
               if(w =='W') w='B';
               else if(w == 'B') w= 'W';
            }
            if(w =='W') w='B';
            else if(w == 'B') w= 'W';
        }
        return Math.max(result_wb, result_bw);
    }
}
