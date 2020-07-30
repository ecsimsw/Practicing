package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//04:13
public class b12100_시뮬레이션_2048 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        s= board.length;
        g =board[0].length;

        //func(5, board);
        move(3);
        printBoard();
        //System.out.print(max);

        move(4);
        printBoard();
    }

    static int s;
    static int g;

    static int[][] board;

    static int max;

    static void func(int n, int[][] board){
        if(n==0){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j]>max) max = board[i][j];
                }
            }
            return;
        }
        for(int i=1; i<5;i++){
            move(i);
            int[][] boardOri = copyBoard();
            func(n-1,board);
            board = boardOri;
        }
    }

    static int[][] copyBoard(){
        int[][] ori = new int[s][g];

        for(int i=0; i<s; i++){
            for(int j=0; j<g; j++){
                ori[i][j] = board[i][j];
            }
        }

        return ori;
    }

    static void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void move(int dir){
        if(dir == 1){  // 위로
            for(int s =0; s<board.length-1; s++) {
                for (int g = board[0].length - 1; g > 0; g--) {
                    if (board[s][g] == 0) {
                        for (int m = s; m < board.length - 1; m++) {
                            board[m][g] = board[m + 1][g];
                        }
                        board[board.length - 1][g] = 0;
                    }
                }
            }

            for(int s =0; s<board.length-1; s++){
                for(int g=0; g<board[0].length; g++) {
                    if(board[s][g] == board[s+1][g]){
                        board[s][g] = 2*board[s][g];

                        for(int m = s+1; m<board.length-1; m++){
                            board[m][g] = board[m+1][g];
                        }
                        board[board.length-1][g] = 0;
                    }
                }
            }
        }

        else if(dir == 2){  // 아래로
            for(int s =0; s<board.length; s++){
                for(int g = board[0].length-1; g>0; g--){
                    if(board[s][g]==0){
                        for(int m = s; m>0; m--){
                            board[m][g] = board[m-1][g];
                        }
                        board[0][g] = 0;
                    }
                }
            }

            for(int s =board.length-1; s>0; s--){
                for(int g=0; g<board[0].length; g++) {
                    if(board[s][g] == board[s-1][g]){
                        board[s][g] = 2*board[s][g];

                        for(int m = s-1; m>0; m--){
                            board[m][g] = board[m-1][g];
                        }
                        board[0][g] = 0;
                    }
                }
            }
        }

        else if(dir == 3){ // 좌로
            for(int s =0; s<board.length; s++){
                for(int g = 0; g<board[0].length-1; g++){
                    if(board[s][g]==0){
                        for(int m = g; m<board[0].length-1; m++){
                            board[s][m] = board[s][m+1];
                        }
                        board[s][board[0].length-1] = 0;
                    }
                }
            }

            for(int s =0; s<board.length; s++){
                 for(int g=0; g<board[0].length-1; g++) {
                    if(board[s][g] == board[s][g+1]){
                        board[s][g] = 2*board[s][g];

                        for(int m = g+1; m<board[0].length-1; m++){
                            board[s][m] = board[s][m+1];
                        }
                        board[s][board[0].length-1] = 0;
                    }
                }
            }
        }

        else if(dir == 4){ // 우
            for(int s =0; s<board.length; s++){
                for(int g = board[0].length-1; g>0; g--){
                    if(board[s][g]==0){

                        ///
                        for(int m = g; m>0; m--){
                            board[s][m] = board[s][m-1];
                        }
                        board[s][0] = 0;
                        ////


                    }
                }
            }

            for(int s =0; s<board.length; s++){
                for(int g=board[0].length-1; g>0; g--) {
                    if(board[s][g] == board[s][g-1]){
                        board[s][g] = 2*board[s][g];

                        for(int m = g-1; m>0; m--){
                            board[s][m] = board[s][m-1];
                        }
                        board[s][0] = 0;
                    }
                }
            }
        }
    }
}
