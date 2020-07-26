package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2178_bfs_미로찾기 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++ ) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int[] move_s = new int[]{0,0,1,-1};
        int[] move_g = new int[]{-1,1,0,0};

        LinkedList<Integer> q_s = new LinkedList<>();
        LinkedList<Integer> q_g = new LinkedList<>();

        boolean[][] isVisit = new boolean[N][M];
        q_g.offer(0);
        q_s.offer(0);
        isVisit[0][0] = true;
        int cnt=1;
        boolean finish = false;

        while(!q_g.isEmpty()){
            cnt++;
            int search = q_g.size();

            for(int n=0; n<search; n++){
                int s = q_s.poll();
                int g = q_g.poll();

                for(int i=0; i<4; i++){
                    int next_s = s+move_s[i];
                    int next_g = g+move_g[i];

                    if(next_s<0|| next_s>= N || next_g<0 || next_g>=M) continue;
                    if(board[next_s][next_g] ==0) continue;
                    if(isVisit[next_s][next_g]==true) continue;

                    isVisit[next_s][next_g] = true;
                    if(next_s==board.length-1 && next_g== board[0].length-1){
                        finish =true;
                        break; }

                    q_g.offer(next_g);
                    q_s.offer(next_s);
                }

                if(finish) break;
            }
            if(finish)break;
        }


        System.out.print(cnt);
    }
}
