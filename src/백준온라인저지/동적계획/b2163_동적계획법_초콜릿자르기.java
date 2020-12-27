package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2163_동적계획법_초콜릿자르기 {
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

        split(n,m);

//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=m; j++){
//                System.out.print(board[i][j] + "  ");
//            }
//            System.out.println();
//        }

        System.out.print(board[n][m]);
    }

    static int[][] board;

    static int split(int x, int y){

        if(x <=1 && y <=1) return 0;

        if(board[x][y] != 0) return board[x][y];

        int result =0;

        if(x%2 !=0 && x!=1){
            result += 1;
            result += split(1,y);
            result += split(x-1,y);
        }
        else if(y %2 != 0 && y!=1){
            result += 1;
            result += split(x,1);
            result += split(x, y-1);
        }
        else if(x==1 || y==1){
            if(x==1) result += y-1;
            if(y==1) result += x-1;
        }
        else{
            result += 1;
            result += (split(x/2, y)*2);
        }

        board[x][y] = result;

        return result;
    }
}
