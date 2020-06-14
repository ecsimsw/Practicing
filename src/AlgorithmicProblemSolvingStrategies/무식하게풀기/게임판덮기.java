package AlgorithmicProblemSolvingStrategies.무식하게풀기;

/*
  주어진 게임판의 빈칸에 3칸자리 ㄱ자의 블록을 회전하여 완벽히 채울 수 있다면 true
 */

import java.util.Arrays;
import java.util.LinkedList;

public class 게임판덮기 {
    static public void main(String[] args) {
        boolean[][] board = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        System.out.println(fillBoard(0,0,board,6));
    }

    static public int fillBoard(int s, int g, boolean[][] board, int left){
        if(s >= board.length && g>=board.length){
            if(left == 0) {return 1;}
            else{return 0;}
        }

        if(g>=board[0].length){
            s ++;
            g = 0;
        }

        if(board[s][g] == true){return fillBoard(s+1, g+1, board, left);}

        int count = 0;
        for(int i =0; i<4; i++){

            if(i==0){  // L
                if(!board[s+1][g] && !board[s+1][g+1]) {
                    if(s+1 < board.length && g+1 < board[0].length){
                        board[s][g] = true;
                        board[s + 1][g] = true;
                        board[s + 1][g + 1] = true;
                        count += fillBoard(s+1, g+1, board, left-3);
                    }
                }
            }
            else if(i==1){  // ㅢ
                if(!board[s+1][g] && !board[s+1][g-1]) {
                    if(s+1 < board.length && g-1 > -1){
                        board[s][g] = true;
                        board[s + 1][g] = true;
                        board[s + 1][g -1] = true;
                        count += fillBoard(s+1, g+1, board, left-3);
                    }
                }
            }
            else if(i==2){  // ㄱ
                if(!board[s-1][g-1] && !board[s-1][g]) {
                    if(s-1 > -1 && g-1 > -1){
                        board[s][g] = true;
                        board[s - 1][g] = true;
                        board[s - 1][g -1] = true;
                        count += fillBoard(s+1, g+1, board, left-3);
                    }
                }
            }
            else if(i==3) {  // ㅣㅡ
                if (!board[s - 1][g + 1] && !board[s - 1][g]) {
                    if (s - 1 > -1 && g + 1 < board[0].length) {
                        board[s][g] = true;
                        board[s - 1][g] = true;
                        board[s - 1][g + 1] = true;
                        count += fillBoard(s + 1, g + 1, board, left - 3);
                    }
                }
            }
        }

        return count;
    }
}
