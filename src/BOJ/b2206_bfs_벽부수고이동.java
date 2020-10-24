package BOJ;

import java.util.*;
import java.io.*;

public class b2206_bfs_벽부수고이동 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        N = Integer.parseInt(s.split(" ")[0]);
        M = Integer.parseInt(s.split(" ")[1]);

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){

            String[] line = br.readLine().split("");

            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        findWay();
    }

    static int min = 1000001;
    static int[][] board;
    static boolean[][] visited;

    static int[] move_s = new int[]{0,0,1,-1};
    static int[] move_g = new int[]{1,-1,0,0};

    static int M;
    static int N;

    static LinkedList<Integer> stack_s = new LinkedList<>();
    static LinkedList<Integer> stack_g = new LinkedList<>();

    static boolean brkWall;

    static void findWay(){
        brkWall = false;

        stack_s = new LinkedList<>();
        stack_g = new LinkedList<>();

        stack_s.add(0);
        stack_g.add(0);

        visited[0][0] = true;

        dfs(1);
        if(min == 1000001) { min = -1; }
        System.out.print(min);
    }

    static void dfs(int score){
        int s = stack_s.peekLast();
        int g = stack_g.peekLast();

        if(s==N-1 && g == M-1) {
            if(score < min){
                min = score;
            }
        }

        for(int i=0; i<4; i++){
            int next_s = s + move_s[i];
            int next_g = g + move_g[i];

            if(next_s<0 || next_s >= N || next_g <0 || next_g >=M) continue;

            if(visited[next_s][next_g]) continue;

            if(board[next_s][next_g] == 0){
                visited[next_s][next_g] = true;
                stack_s.offer(next_s);
                stack_g.offer(next_g);
                dfs(score+1);
                stack_s.pollLast();
                stack_g.pollLast();
            }
            else if(board[next_s][next_g]==1 && brkWall == false){
                brkWall = true;
                visited[next_s][next_g] = true;
                stack_s.offer(next_s);
                stack_g.offer(next_g);
                dfs(score+1);
                stack_s.pollLast();
                stack_g.pollLast();
            }
        }
    }

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
