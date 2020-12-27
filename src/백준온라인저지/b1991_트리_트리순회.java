package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1991_트리_트리순회 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new Character[n][3];

        String[] line;
        for(int i =0; i<n; i++){
            line = br.readLine().split(" ");
            if(!line[0].equals(".")) board[i][0] = line[0].charAt(0);
            if(!line[1].equals(".")) board[i][1] = line[1].charAt(0);
            if(!line[2].equals(".")) board[i][2] = line[2].charAt(0);
        }
        mlr(0);
        System.out.println();
        lmr(0);
        System.out.println();
        lrm(0);
    }
    static int n;
    static Character[][] board;

    static void mlr(int middle){
        System.out.print(board[middle][0]);

        if(board[middle][1] != null){
            int left = findIndex(board[middle][1]);
            mlr(left);
        }

        if(board[middle][2] != null){
            int right = findIndex(board[middle][2]);
            mlr(right);
        }
    }

    static void lmr(int middle){

        if(board[middle][1] != null){
            int left = findIndex(board[middle][1]);
            lmr(left);
        }

        System.out.print(board[middle][0]);

        if(board[middle][2] != null){
            int right = findIndex(board[middle][2]);
            lmr(right);
        }
    }

    static void lrm(int middle){

        if(board[middle][1] != null){
            int left = findIndex(board[middle][1]);
            lrm(left);
        }

        if(board[middle][2] != null){
            int right = findIndex(board[middle][2]);
            lrm(right);
        }

        System.out.print(board[middle][0]);
    }

    static int findIndex(char c){
        for(int i =0; i<n; i++){
            if(board[i][0] == c){
                return i;
            }
        }
        return -1;
    }
}
