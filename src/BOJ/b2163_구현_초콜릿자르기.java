package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class b2163_구현_초콜릿자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        board = new int[301][301];

        board[1][1] = 0;
        board[2][1] = 1;
        board[1][2] = 1;
        board[3][1] = 2;
        board[1][3] = 2;

        System.out.print(split(n,m));
    }

    static int[][] board;

    static int split(int x, int y){
        if(x ==1 && y ==1) return 0;

        int bigger = x >= y ? x : y;
        int smaller = x >= y ? y : x;

        if(board[bigger][smaller] !=0 ){
            return board[bigger][smaller];
        }

        int result =0;

        if(bigger%2 !=0){
            result += split(1,smaller);
            result += split(bigger-1,smaller);
        }
        else if(smaller %2 != 0){
            result += split(bigger,1);
            result += split(bigger, smaller-1);
        }
        else{
            result += split(bigger/2, smaller);
        }

        board[bigger][smaller] = result;

        return result;
    }
}
