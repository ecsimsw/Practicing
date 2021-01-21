package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class b2667_bfs_단지번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        boolean[][] visited = new boolean[n][n];

        LinkedList<Integer> villages = new LinkedList<>();
        for(int s=0; s<n; s++){
            for(int g=0; g<n; g++){
                if(map[s][g] == 0 || visited[s][g] == true){
                    continue;
                }
                int cnt = bfs(s, g, map, visited);
                villages.offer(cnt);
            }
        }
        System.out.println(villages.size());
        Collections.sort(villages);
        for(int i : villages){
            System.out.println(i);
        }
    }

    private static int[] move_s = new int[]{0,0,1,-1};
    private static int[] move_g = new int[]{1,-1,0,0};
    private static int n;

    private static int bfs(int s, int g, int[][] map, boolean[][] visited){
        LinkedList<Integer> queue_s = new LinkedList<>();
        LinkedList<Integer> queue_g = new LinkedList<>();

        int count =0;

        queue_g.offer(g);
        queue_s.offer(s);
        visited[s][g] = true;
        count++;

        while(!queue_s.isEmpty()){
            s = queue_s.poll();
            g = queue_g.poll();

            for(int i=0; i<4; i++){
                int next_s = s+move_s[i];
                int next_g = g+move_g[i];

                if(next_s<0 || next_s >= n || next_g <0 || next_g >= n){
                    continue;
                }

                if(visited[next_s][next_g] || map[next_s][next_g] == 0){
                    continue;
                }

                queue_s.offer(next_s);
                queue_g.offer(next_g);

                visited[next_s][next_g] = true;
                count++;
            }
        }

        return count;
    }
}
