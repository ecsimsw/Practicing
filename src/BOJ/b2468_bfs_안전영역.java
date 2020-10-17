package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2468_bfs_안전영역 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            String[] nums = line.split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int board_max_height =0;

        for(int s=0; s<n; s++){
            for(int g=0; g<n; g++){
                if(board[s][g]>board_max_height){
                    board_max_height = board[s][g];
                }
            }
        }

        for(int h =0; h<board_max_height; h++){
            findSafe(h);
        }

        System.out.println(max_count);
    }

    static int n;
    static int[][] board;

    static int max_count = 0;
    static int max_height= 0;

    static int[] move_s = new int[]{0,0,1,-1};
    static int[] move_g = new int[]{1,-1,0,0};

    static boolean[][] visited;

    static void findSafe(int height){

        visited= new boolean[n][n];

        int now_s;
        int now_g;

        int safeCount =0;

        for(int s=0; s<n; s++){
            for(int g=0; g<n; g++){
                if(board[s][g]> height && visited[s][g] == false){
                    now_s = s;
                    now_g = g;

                    bfs(now_s, now_g, height);
                    safeCount++;
                }
            }
        }
        

        if(safeCount > max_count){
            max_height = height;
            max_count = safeCount;
        }
    }

    static void bfs(int now_s, int now_g, int height){

        Queue<Integer> queue_s = new LinkedList<>();
        Queue<Integer> queue_g = new LinkedList<>();

        queue_g.offer(now_g);
        queue_s.offer(now_s);

        visited[now_s][now_g] = true;

        while(!queue_s.isEmpty()){
            int s = queue_s.poll();
            int g = queue_g.poll();

            int next_s=0;
            int next_g=0;

            for(int i=0; i<4; i++){
                next_s = s+move_s[i];
                next_g = g+move_g[i];

                if(next_s<0 || next_s>= n || next_g <0 || next_g >= n) continue;

                if(board[next_s][next_g] > height && visited[next_s][next_g] == false){
                    visited[next_s][next_g] = true;
                    queue_g.offer(next_g);
                    queue_s.offer(next_s);
                }
            }
        }
    }


}
