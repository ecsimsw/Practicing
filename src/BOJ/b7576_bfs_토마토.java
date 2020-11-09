package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class b7576_bfs_토마토 {
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splited = br.readLine().split(" ");
        int g_len = Integer.parseInt(splited[0]);
        int s_len = Integer.parseInt(splited[1]);

        int[][] board = new int[s_len][g_len];

        for(int i=0; i<s_len; i++){
            String[] line = br.readLine().split(" ");

            for(int j=0; j<g_len; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        Queue<Point_7576> queue = new LinkedList<>();

        int[] m_s = new int[]{0, 1, 0, -1};
        int[] m_g = new int[]{1, 0, -1, 0};


        for (int i = 0; i < s_len; i++) {
            for (int j = 0; j < g_len; j++) {
                if (board[i][j] == 1) {
                    int s = i;
                    int g = j;

                    queue.offer(new Point_7576(s, g));
                }
            }
        }

        int day =-1;
        while (!queue.isEmpty()) {
            int numberOfTomato = queue.size();
            for (int ripe = 0; ripe < numberOfTomato ; ripe++) {
                Point_7576 p = queue.poll();

                int s = p.s;
                int g = p.g;

                for (int m = 0; m < 4; m++) {
                    int next_s = s + m_s[m];
                    int next_g = g + m_g[m];

                    if (next_g > -1 && next_s > -1 && next_g < g_len && next_s < s_len) {
                        if (board[next_s][next_g] == 0) {
                            board[next_s][next_g] = 1;

                            queue.offer(new Point_7576(next_s, next_g));
                        }
                    }
                }
            }
            day++;
        }

        for (int i = 0; i < s_len; i++) {
            for (int j = 0; j < g_len; j++) {
                if(board[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day);
    }
}

class Point_7576 {
    int g;
    int s;
    public Point_7576(int s, int g){
        this.s= s;
        this.g = g;
    }
}
