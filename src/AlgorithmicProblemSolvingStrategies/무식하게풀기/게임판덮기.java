package AlgorithmicProblemSolvingStrategies.무식하게풀기;

/*
  주어진 게임판의 빈칸에 3칸자리 ㄱ자의 블록을 회전하여 완벽히 채울 수 있다면 true
 */

import java.util.Arrays;
import java.util.LinkedList;

public class 게임판덮기 {
    static public void main(String[] args) {
        boolean[][] board = new boolean[][]{
                {true,false, false, false,false, false, true},
                {true,false, false, false,false, false, true},
                {true,true, false, false, true, true, true}
        };
        System.out.println(fillBoard(0,0,board,12));
    }

    static int[] typesG = {1,1,-1,-1,0};
    static int[] typesS = {1,-1,-1,1,0};
    static int[] score = {-3,-3,-3,-3,0};
    static public int fillBoard(int s, int g, boolean[][] board, int left){
        System.out.println(s+" "+g + " "+left );
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        if(s >= board.length-1 && g>board.length){
            if(left == 0) {System.out.println("====== 1"); return 1;}
            else{System.out.println("======= 0"); return 0;}
        }

        if(g>=board[0].length){ s ++; g = 0; }

        if(board[s][g] == true){return fillBoard(s, g+1, board, left);}

        int count = 0;
        for(int i =0; i<4; i++){
            if(s+typesS[i] < board.length && s+typesS[i] > -1 && g+typesG[i] < board[0].length && g+typesG[i] > -1){
                if(!board[s+typesS[i]][g] && !board[s+typesS[i]][g+typesG[i] ]) {
                    System.out.println("type : "+ i);
                    board[s][g] = true;
                    board[s + typesS[i]][g] = true;
                    board[s + typesS[i]][g + typesG[i]] = true;
                    count += fillBoard(s, g+1, board, left+score[i]);
                    board[s][g] = false;
                    board[s + typesS[i]][g] = false;
                    board[s + typesS[i]][g + typesG[i]] = false;
                }
            }
        }

        return count + fillBoard(s, g + 1, board, left);
    }
}

    /*
    static public int fillBoard(int s, int g, boolean[][] board, int left){
        System.out.println(s+" "+g + " "+left );
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        if(s >= board.length-1 && g>board.length){
            if(left == 0) {System.out.println("====== 1"); return 1;}
            else{System.out.println("======= 0"); return 0;}
        }

        if(g>=board[0].length){
            s ++;
            g = 0;
        }

        if(board[s][g] == true){return fillBoard(s, g+1, board, left);}

        int count = 0;
        for(int i =0; i<4; i++){
            if(i==0){  // L
                if(s+typesS[i] < board.length && s+typesS[i] > -1 && g+typesG[i] < board[0].length && g+typesG[i] > -1){
                    if(!board[s+typesS[i]][g] && !board[s+typesS[i]][g+typesG[i] ]) {
                        System.out.println("type : "+ i);
                        board[s][g] = true;
                        board[s + typesS[i]][g] = true;
                        board[s + typesS[i]][g + typesG[i]] = true;
                        count += fillBoard(s, g+1, board, left-3);
                        board[s][g] = false;
                        board[s + typesS[i]][g] = false;
                        board[s + typesS[i]][g + typesG[i] ] = false;
                    }
                }
            }
            else if(i==1){  // ㅢ
                if(s+1 < board.length && g-1 > -1){
                     if(!board[s+1][g] && !board[s+1][g-1]) {
                        System.out.println("type : "+ i);
                        board[s][g] = true;
                        board[s + 1][g] = true;
                        board[s + 1][g -1] = true;
                        count += fillBoard(s, g+1, board, left-3);
                        board[s][g] = false;
                        board[s + 1][g] = false;
                        board[s + 1][g -1] = false;
                    }
                }
            }
            else if(i==2){  // ㄱ
                if(s-1 > -1 && g-1 > -1){
                    if(!board[s-1][g-1] && !board[s-1][g]) {
                        System.out.println("type : "+ i);
                        board[s][g] = true;
                        board[s - 1][g] = true;
                        board[s - 1][g -1] = true;
                        count += fillBoard(s, g+1, board, left-3);
                        board[s][g] = false;
                        board[s - 1][g] = false;
                        board[s - 1][g -1] = false;
                    }
                }
            }
            else if(i==3) {  // ㅣㅡ
                if (s - 1 > -1 && g + 1 < board[0].length) {
                    if (!board[s - 1][g + 1] && !board[s - 1][g]) {
                        System.out.println("type : "+ i);
                        board[s][g] = true;
                        board[s - 1][g] = true;
                        board[s - 1][g + 1] = true;
                        count += fillBoard(s, g + 1, board, left - 3);
                        board[s][g] = false;
                        board[s - 1][g] = false;
                        board[s - 1][g + 1] = false;
                    }
                }
            }
        }

        return fillBoard(s, g + 1, board, left);
    }
}

     */
