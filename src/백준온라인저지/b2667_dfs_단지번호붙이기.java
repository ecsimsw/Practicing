package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class b2667_dfs_단지번호붙이기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split("");

            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        boolean[][] isVisit = new boolean[n][n];

        int[] move_s = new int[]{0,1,0,-1};
        int[] move_g = new int[]{1,0,-1,0};

        LinkedList<Integer> counts = new LinkedList<>();

        int setCnt =0;
        for(int s=0; s<n; s++){
            for(int g=0; g<n; g++){
                if(isVisit[s][g]== true) continue;
                if(map[s][g] ==0) continue;

                Queue<Integer> queue_s = new LinkedList<>();
                Queue<Integer> queue_g = new LinkedList<>();
                queue_s.offer(s);
                queue_g.offer(g);
                isVisit[s][g] = true;
                setCnt++;

                int cnt =1;

                while(!queue_s.isEmpty()){
                    int now_s = queue_s.poll();
                    int now_g = queue_g.poll();

                    for(int i=0; i<4; i++){
                        int next_s = now_s+move_s[i];
                        int next_g = now_g+move_g[i];

                        if(next_g < 0 || next_s<0 || next_g>= n || next_s >=n) continue;
                        if(isVisit[next_s][next_g]==false){
                            isVisit[next_s][next_g] = true;
                            if(map[next_s][next_g]==1){
                                cnt++;
                                queue_s.offer(next_s);
                                queue_g.offer(next_g);
                            }
                        }
                    }
                }
                counts.add(cnt);
            }
        }
        System.out.println(setCnt);
        Collections.sort(counts);
        for(int i : counts)
            System.out.println(i);
    }
}
