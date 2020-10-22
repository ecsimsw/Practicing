package BOJ;

import java.util.*;
import java.io.*;

public class b2206_bfs_벽부수고이동 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }

    static int min;
    static int[][] board;
    static boolean[][] visited;

    static int[] move_s = new int[]{0,0,1,-1};
    static int[] move_g = new int[]{1,-1,0,0};

    static int M;
    static int N;

    static void bfs(){

        boolean brkWall = false;

        LinkedList<Integer> stack_s = new LinkedList<>();
        LinkedList<Integer> stack_g = new LinkedList<>();

        stack_s.add(0);
        stack_g.add(0);

        visited[0][0] = true;

        int beforeBrk_s = 0;
        int beforBrk_g = 0;

        while(!stack_s.isEmpty()){
            int s = stack_s.pollLast();
            int g = stack_g.pollLast();

            for(int i=0; i<4; i++){
                int next_s = s + move_s[i];
                int next_g = g + move_g[i];

                if(next_s<0 || next_s >= M || next_g <0 || next_g >=N) continue;

                if(visited[next_s][next_g]) continue;

                if(brkWall == false && board[next_s][next_g] == 1){
                    brkWall = true;
                    stack_s.offer(next_s);
                    stack_g.offer(next_g);
                    visited[next_s][next_g] = true;
                }
            }
        }
    }

    static void dfs(int brk_s, int brk_g){
        LinkedList<Integer> stack_s = new LinkedList<>();
        LinkedList<Integer> stack_g = new LinkedList<>();

        stack_s.offer(brk_s);
        stack_g.offer(brk_g);

        boolean searchFin = false;

        while(!stack_s.isEmpty()){
            int s = stack_s.pollLast();
            int g = stack_g.pollLast();

            for(int i=0; i<4; i++){
                int next_s = s + move_s[i];
                int next_g = g + move_g[i];

                if(next_s<0 || next_s >= M || next_g <0 || next_g >=N) continue;

                if(visited[next_s][next_g]) continue;

                if(board[next_s][next_g] == 1) continue;

                visited[next_s][next_g] = true;

                stack_s.offer(next_s);
                stack_g.offer(next_g);


            }
        }
    }
}
