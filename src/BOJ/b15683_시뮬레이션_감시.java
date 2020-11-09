package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15683_시뮬레이션_감시 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N_s = Integer.parseInt(line[0]);
        N_g = Integer.parseInt(line[1]);

        min = N_s *N_g;
        board = new int[N_s][N_g];

        for (int i = 0; i < N_s; i++) {
            String[] numbers = br.readLine().split(" ");
            for (int j = 0; j < N_g; j++) {
                board[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        func(0, 0, board);

        System.out.print(min);
    }

    static int[][] board;
    static int N_s;
    static int N_g;

    static int min;
    static int[][] newBoard;

    static void func(int s, int g, int[][] board) {

        /*
        System.out.println(s+" "+g);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println();
        */

        if (g >= N_g) {
            s++;
            g = 0;
            if (s >= N_s) {
                int cnt = 0;
                for (int i = 0; i < N_s; i++) {
                    for (int j = 0; j < N_g; j++) {
                        if (board[i][j] == 0) cnt++;
                    }
                }
                if (cnt < min) min = cnt;

                return;
            }
        }

        int now = board[s][g];

        if (now >= 1 && now <= 6) {
            if (now == 1) {
                // 우
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                right(newBoard, s,g);
                func(s, g + 1, newBoard);

                // 좌
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                left(newBoard, s,g);
                func(s, g + 1, newBoard);

                // 상
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                up(newBoard,s,g);
                func(s, g + 1, newBoard);

                // 하
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                down(newBoard,s,g);
                func(s, g + 1, newBoard);
            }
            else if (now == 2) {
                // 상 하
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                down(newBoard,s,g);
                up(newBoard,s,g);
                func(s, g + 1, newBoard);

                // 좌 우
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                right(newBoard, s,g);
                left(newBoard, s,g);
                func(s, g + 1, newBoard);
            }
            else if (now == 3) {
                // 상 우
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);

                up(newBoard,s,g);
                right(newBoard, s,g);
                func(s, g + 1, newBoard);

                // 우 하
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);

                right(newBoard, s,g);
                down(newBoard,s,g);
                func(s, g + 1, newBoard);

                // 하 좌
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);

                left(newBoard, s,g);
                down(newBoard,s,g);
                func(s, g + 1, newBoard);

                // 좌 상
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                left(newBoard, s,g);
                up(newBoard,s,g);
                func(s, g + 1, newBoard);
            }
            else if (now == 4) {
                // 좌 상 우
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                up(newBoard,s,g);
                right(newBoard, s,g);
                left(newBoard, s,g);
                func(s, g + 1, newBoard);

                // 상 우 하
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                right(newBoard, s,g);
                down(newBoard,s,g);
                up(newBoard,s,g);
                func(s, g + 1, newBoard);

                // 우 하 좌
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                down(newBoard,s,g);
                right(newBoard, s,g);
                left(newBoard, s,g);
                func(s, g + 1, newBoard);

                // 하 좌 상
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                down(newBoard,s,g);
                up(newBoard,s,g);
                left(newBoard, s,g);
                func(s, g + 1, newBoard);

            }
            else if (now == 5) {
                //상하좌우
                newBoard = new int[N_s][N_g];
                newBoard = setNewBoard(newBoard, board);
                down(newBoard,s,g);
                up(newBoard,s,g);
                right(newBoard, s,g);
                left(newBoard, s,g);
                func(s, g + 1, newBoard);
            }
        }

        func(s, g + 1, board);
    }

    static int[][] setNewBoard(int[][] newBoard, int[][] board){
        for (int i = 0; i < N_s; i++) {
            for (int j = 0; j < N_g; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        return newBoard;
    }

    static void left(int[][] newBoard, int s, int g){
        for (int i = g-1; i >= 0; i--) {
            if (newBoard[s][i] == 6) break;
            if( newBoard[s][i]>=1 && newBoard[s][i]<=5) continue;
            newBoard[s][i] = -1;
        }
    }

    static void right(int[][] newBoard, int s, int g) {
        for (int i = g+1; i < N_g; i++) {
            if (newBoard[s][i] == 6) break;
            if( newBoard[s][i]>=1 && newBoard[s][i]<=5) continue;
            newBoard[s][i] = -1;
        }
    }

    static void up(int[][] newBoard, int s, int g){
        for (int i = s-1; i >=0; i--) {
            if (newBoard[i][g] == 6) break;
            if( newBoard[i][g]>=1 && newBoard[i][g]<=5) continue;
            newBoard[i][g] = -1;
        }
    }

    static void down(int[][] newBoard, int s, int g){
        for (int i = s+1; i < N_s; i++) {
            if (newBoard[i][g] == 6) break;
            if( newBoard[i][g]>=1 && newBoard[i][g]<=5) continue;
            newBoard[i][g] = -1;
        }
    }
}
