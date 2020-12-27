package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2579_동적계획법_계단오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n+1];
        dpBoard = new int[n+1];

        for(int i=1; i<=n; i++){
            board[i] = Integer.parseInt(br.readLine());
       }

        if(n==1) { System.out.println(board[1]); return; }
        if(n==2) { System.out.println(board[1] + board[2]); return; }

        dpBoard[1] = board[1];
        dpBoard[2] = board[1]+board[2];

        for(int i =3; i<n+1; i++){
            int r = Math.max(dpBoard[i-2]+board[i], dpBoard[i-3]+board[i]+board[i-1]);
            dpBoard[i] =r;
        }

        System.out.println(dpBoard[n]);
    }
    static int[] board;
    static int[] dpBoard;
    static int n;
}
