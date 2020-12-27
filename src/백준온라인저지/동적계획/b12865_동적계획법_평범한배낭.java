package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b12865_동적계획법_평범한배낭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        itemV = new int[N+1];
        itemW = new int[N+1];

        for(int i=1; i<=N; i++){
            line = br.readLine();
            itemW[i] = Integer.parseInt(line.split(" ")[0]);
            itemV[i] = Integer.parseInt(line.split(" ")[1]);
        }

        board = new int[N+1][M+1];

        dp();

        System.out.println(board[N][M]);
    }

    static int N;
    static int M;
    static int[][] board;
    static int[] itemW;
    static int[] itemV;

    static void dp(){

        for(int item=1; item<=N; item++){
            for(int weight=1; weight<=M; weight++){
                if(weight < itemW[item]){
                    board[item][weight] = board[item-1][weight];
                }
                else{
                    board[item][weight] = Math.max(board[item-1][weight], itemV[item]+board[item-1][weight-itemW[item]]);
                }
            }
        }
    }
}

