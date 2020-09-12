package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b14502_bfs_연구소 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");

        row =Integer.parseInt(strings[1]);
        col =Integer.parseInt(strings[0]);

        board = new int[col][row];

        for(int s=0; s<col; s++) {
            String[] nums = br.readLine().split(" ");
            for(int g=0; g<row; g++) {
                   board[s][g]= Integer.parseInt(nums[g]);
            }
        }

        combination(3, 0);

        System.out.print(max);
    }

    static int row ;
    static int  col;
    static int max=0;

    static int[][] board;

    static void combination(int left, int from){

        if(left ==0){
            bfs(board);
            return;
        }

        for(int i=from; i<row*col; i++){
            if(board[i/row][i%row]==0){
                board[i/row][i%row] =1;
                combination(left-1, i+1);
                board[i/row][i%row] =0;
            }
        }
    }

    static void bfs(int[][] board){

        int[][] tempBoard = new int[col][row];

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                tempBoard[i][j] = board[i][j];
            }
        }

        Queue<Integer>  s_q = new LinkedList<>();
        Queue<Integer> g_q = new LinkedList<>();

        boolean[][] checked = new boolean[col][row];
        int[] move_s =  new int[]{0,0,1,-1};
        int[] move_g = new int[]{1,-1,0,0};

        for(int s=0; s<col; s++) {
            for(int g=0; g<row; g++){
                if(checked[s][g] == false && tempBoard[s][g] ==2){
                    s_q.offer(s);
                    g_q.offer(g);

                    while(!s_q.isEmpty()){
                        int now_s = s_q.poll();
                        int now_g = g_q.poll();

                        for(int i=0; i<4; i++){
                            int next_s = now_s + move_s[i];
                            int next_g = now_g+ move_g[i];
                            if(next_s<0 || next_g<0 || next_s>=col || next_g>=row)
                                continue;

                            if(tempBoard[next_s][next_g]==0 && checked[next_s][next_g] == false){
                                tempBoard[next_s][next_g] =2;
                                checked[next_s][next_g] = true;
                                s_q.offer(next_s);
                                g_q.offer(next_g);
                            }
                        }
                    }
                }
            }
        }

        int zeroCnt=0;
        for(int s=0; s<col; s++) {
            for(int g=0; g<row; g++){
                if(tempBoard[s][g]==0){
                    zeroCnt++;
                }
            }
        }
        if(zeroCnt > max){
            max = zeroCnt;
        }
    }
}
