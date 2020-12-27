package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1012_bfs_유기농배추{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<test; i++){
            String[] line = br.readLine().split(" ");
            int M = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            int K = Integer.parseInt(line[2]);
            int[][] board = new int[N][M];
            for(int j=0; j<K; j++){
                String[] position = br.readLine().split(" ");
                int g = Integer.parseInt(position[0]);
                int s = Integer.parseInt(position[1]);

                board[s][g] = 1;
            }

            boolean[][] isVisit = new boolean[board.length][board[0].length];

            int[] move_s = new int[]{0,0,1,-1};
            int[] move_g = new int[]{1,-1,0,0};

            Queue<Integer> q_s = new LinkedList<>();
            Queue<Integer> q_g = new LinkedList<>();

            int cnt =0;

            for(int s=0; s<board.length; s++){
                for(int g=0; g<board[0].length; g++){
                    if(board[s][g] == 0) continue;
                    if(isVisit[s][g]==true) continue;

                    q_s.offer(s);
                    q_g.offer(g);
                    isVisit[s][g] =true;
                    cnt ++;

                    while(!q_s.isEmpty()){
                        int now_s = q_s.poll();
                        int now_g = q_g.poll();

                        int next_s;
                        int next_g;
                        for(int m=0; m<4; m++){
                            next_s = now_s + move_s[m];
                            next_g = now_g + move_g[m];

                            if(next_g<0 || next_g >= board[0].length
                                    || next_s<0 || next_s>=board.length)
                                continue;

                            if(board[next_s][next_g]==0) continue;
                            if(isVisit[next_s][next_g]==true) continue;

                            isVisit[next_s][next_g] = true;
                            q_s.offer(next_s);
                            q_g.offer(next_g);
                        }
                    }
                }
            }

            sb.append(cnt+"\n");
        }
        System.out.print(sb.toString());
    }
}
