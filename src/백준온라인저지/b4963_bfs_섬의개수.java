package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b4963_bfs_섬의개수 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] size = br.readLine().split(" ");

            w = Integer.parseInt(size[0]);
            h = Integer.parseInt(size[1]);

            if (w == 0 && h == 0) { break; }

            board = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String[] line = br.readLine().split(" ");

                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                }
            }

            int landCount =0;

            for(int s = 0; s<h; s++){
                for(int g =0; g<w; g++){
                    if(visited[s][g] == false && board[s][g] == 1){
                        bfs(s, g);
                        landCount++;
                    }
                }
            }
            sb.append(landCount + " \n");
        }

        System.out.println(sb.toString());
    }
    static int[][] board;

    static int w;
    static int h;

    static int[] move_s = new int[]{0,0,-1,1, 1,-1,1,-1};
    static int[] move_g = new int[]{1,-1,0,0,-1,1,1,-1};

    static boolean[][] visited ;

    static void bfs(int now_s, int now_g){
        Queue<Integer> queue_s = new LinkedList<>();
        Queue<Integer> queue_g = new LinkedList<>();

        queue_s.offer(now_s);
        queue_g.offer(now_g);

        visited[now_s][now_g] = true;

        while(!queue_s.isEmpty()){
            int s = queue_s.poll();
            int g = queue_g.poll();

            for(int i =0; i<8; i++){
                int next_s = s + move_s[i];
                int next_g = g + move_g[i];

                if(next_s< 0 || next_s>= h || next_g<0|| next_g >= w){ continue; }

                if(visited[next_s][next_g]){ continue; }
                if(board[next_s][next_g] == 0){continue;}

                queue_s.offer(next_s);
                queue_g.offer(next_g);

                visited[next_s][next_g] = true;
            }
        }
    }
}
