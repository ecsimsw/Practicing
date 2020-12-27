package 백준온라인저지;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

        func(5, board);

        System.out.print(max);

    }

    static int s;
    static int g;

    static int[][] board;

    static int max;

    static void func(int n, int[][] board){
        if(n==0){
            //System.out.println("=========");
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j]>max) max = board[i][j];
                }
            }
            return;
        }
        for(int i=1; i<5;i++){
            int[][] boardOri = copyBoard(board);
            //printBoard(board);
            func(n-1,move(i, board));
            board = boardOri;
        }
    }

    static int[][] copyBoard(int[][] board){
        int[][] ori = new int[s][g];

        for(int i=0; i<s; i++){
            for(int j=0; j<g; j++){
                ori[i][j] = board[i][j];
            }
        }

        return ori;
    }

    static void printBoard(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] move(int dir, int[][]board){
        if(dir == 1){  // 위로

            for(int s =1; s<board.length; s++){
                for(int g =0; g<board[0].length; g++){
                    int i=0;
                    while(s-i-1>=0){
                        if(board[s-i-1][g]!=0) break;
                        board[s-i-1][g] = board[s-i][g];
                        board[s-i][g] =0;
                        i++;
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
            for(int s = board.length-1; s>0; s--){
                for(int g=0; g<board[0].length; g++){
                    int i=0;
                    while(s+i<board.length){
                        if(board[s+i][g]==0){
                            board[s+i][g] = board[s+i-1][g];
                            board[s+i-1][g] =0;
                        }
                        i++;
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
            for(int s =0; s<board.length; s++) {
                for (int g = 0; g < board[0].length; g++) {
                    int i =0;
                    while(g-i-1>=0){
                        if(board[s][g-i-1]==0){
                            board[s][g-i-1] = board[s][g-i];
                            board[s][g-i] =0;
                        }
                        i++;
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
            for(int s =0; s<board.length; s++) {
                for (int g = board[0].length; g > 0; g--) {
                    int i=0;
                    while(g+i<board[0].length){
                        if(board[s][g+i]==0){
                            board[s][g+i] = board[s][g+i-1];
                            board[s][g+i-1] =0;
                        }
                        i++;
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
        return board;
    }
}
