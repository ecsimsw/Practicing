package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b1926_BFS {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1, 1, 0, 0 , 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1}
        };

        int s_len = board.length;
        int g_len = board[0].length;

        boolean[][] vis = new boolean[s_len][g_len];

        int count =0;
        int now_size =0;
        int max_size =0;

        int s = 0;
        int g = 0;

        int[] move_s = new int[]{0,1,0,-1};
        int[] move_g = new int[]{1,0,-1,1};

        Queue<Point> queue =new LinkedList<>();
        for(int i =0; i<s_len; i++){
            for(int j=0; j<g_len; j++){
                if(vis[i][j]==false && board[i][j] == 1){
                    count++;
                    while(queue.isEmpty()==false){
                        Point p = queue.poll();
                        s = p.s;
                        g = p.g;

                        for(int m =0; m<4; m++){
                            s = s+ move_s[m];
                            g = g+ move_g[m];

                            if(s>=0 && g>=0 && s<s_len && g<g_len){
                                if(board[s][g]==1 && vis[s][g]==false){
                                    queue.add(new Point(s,g));
                                    vis[s][g] = true;
                                }
                            }
                        }
                    }
                }
            }
        }


        System.out.println("count : "+ count);
        System.out.println("max : "+ max_size);
    }
}

class Point{
    int s;
    int g;

    public Point(int s, int g){
        this.s = s;
        this.g = g;
    }
}
