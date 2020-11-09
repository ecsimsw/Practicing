package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1010_동적계획법_다리놓기 {
    static public void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] line;
        int N,M;

        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);

            int[][] board = new int[N+1][M+1];

            for(int right =1; right <=M; right++){
                board[1][right] = right;
            }

            for(int left =2; left<=N; left++){
                for(int right =1; right <=M; right++) {
                    if (left > right) { board[left][right] = 0;continue; }
                    if (left <= right) {
                        board[left][right] = board[left-1][right-1] + board[left][right-1];
                    }
                }
            }

            System.out.println(board[N][M]);
        }
    }
}
