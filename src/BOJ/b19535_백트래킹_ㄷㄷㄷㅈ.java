package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b19535_백트래킹_ㄷㄷㄷㅈ {
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Long[] nums = new Long[6];
//        String[] numbers = br.readLine().split(" ");
//        for(int i=0; i<6; i++){ nums[i] = Long.parseLong(numbers[i]); }

        board = new boolean[7][7];

        board[1][2] = true;
        board[2][1] = true;
        board[2][3] = true;
        board[3][2] = true;
        board[2][5] = true;
        board[5][2] = true;
        board[3][4] = true;
        board[4][3] = true;
        board[4][5] = true;
        board[5][4] = true;
        board[4][6] = true;
        board[6][4] = true;

        points = new int[4];
        isVisit = new boolean[board.length][board.length];

        for(int s= 1; s<board.length; s++){
            points[0] = s;
            func(s,3);
        }

        System.out.println(cnt);
    }
    static boolean[][] board;
    static int[] points;
    static boolean[][] isVisit;

    static int cnt =0;
    static void func(int s, int n){
        if(n==0) {
            cnt++;
            for(int i: points) { System.out.print(i);}
            System.out.println();
            return;}

        for(int i=1; i<board[s].length; i++){
            if(isVisit[s][i]==true || isVisit[i][s] == true) continue;
            if(board[s][i] == true){
                points[4-n] = i;
                isVisit[s][i] = true;
                isVisit[i][s] = true;
                func(i,n-1);
                isVisit[s][i] = false;
                isVisit[i][s] = false;
            }
        }
    }
}
