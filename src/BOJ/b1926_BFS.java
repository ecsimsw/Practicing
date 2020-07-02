package BOJ;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class b1926_BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        String[] input = br.readLine().split(" ");

        int col = Integer.parseInt(input[0]);
        int row = Integer.parseInt(input[1]);

        int[][] board = new int[col][row];

        for(int i=0; i<col; i++){
            String[] content = br.readLine().split(" ");
            for(int j=0; j<row; j++){
                board[i][j] = Integer.parseInt(content[j]);
            }
        }

        int s_len = board.length;
        int g_len = board[0].length;

        boolean[][] vis = new boolean[s_len][g_len];

        int count =0;
        int now_size =0;
        int max_size =0;

        int s = 0;
        int g = 0;

        int[] move_s = new int[]{0,1,0,-1};
        int[] move_g = new int[]{1,0,-1,0};

        Queue<Point> queue =new LinkedList<>();
        for(int i =0; i<s_len; i++){
            for(int j=0; j<g_len; j++){
                if(vis[i][j]==false && board[i][j] == 1){
                    count++;
                    vis[i][j] = true;
                    queue.offer(new Point(i,j));
                    System.out.println("new "+i+" "+j);
                    now_size=1;
                    while(queue.isEmpty()==false){
                        Point p = queue.poll();
                        s = p.s;
                        g = p.g;

                        for(int m =0; m<4; m++){
                            int next_s = s+ move_s[m];
                            int next_g = g+ move_g[m];

                            if(next_s>=0 && next_g>=0 && next_s<s_len && next_g<g_len){
                                if(board[next_s][next_g]==1 && vis[next_s][next_g]==false){
                                    now_size++;
                                    queue.offer(new Point(next_s,next_g));
                                    System.out.println(next_s+" "+next_g);
                                    vis[next_s][next_g] = true;
                                }
                            }
                        }
                    }
                    if(now_size > max_size){max_size = now_size;}
                }
            }
        }

        System.out.println(count);
        System.out.println(max_size);
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
