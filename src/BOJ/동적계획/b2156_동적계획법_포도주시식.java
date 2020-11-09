package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2156_동적계획법_포도주시식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int [n];

        for(int i =0; i<n; i++){
            board[i] = Integer.parseInt(br.readLine());
        }

        dpBoard = new int[n];

        if(n==1) {System.out.print(board[0]); return;}
        if(n==2) {System.out.print(board[0]+board[1]); return;}

        dpBoard[0] = board[0];
        dpBoard[1] = board[1] +board[0];
        dpBoard[2] = Math.max(dpBoard[1],Math.max(board[0],board[1])+board[2]);

        for(int i=3; i<n; i++){
            dpBoard[i] = Math.max(dpBoard[i-1],Math.max(dpBoard[i-3]+board[i-1], dpBoard[i-2])+board[i]);
        }
        System.out.print(dpBoard[n-1]);
    }

    static int[] board;
    static int[] dpBoard;
    static int n;
}
