package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2606_dfs_바이러스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCom = Integer.parseInt(br.readLine());
        int numberOfLine= Integer.parseInt(br.readLine());

        boolean[][] lines = new boolean[numberOfCom+1][numberOfCom+1];
        boolean[] isVisit = new boolean[numberOfCom+1];
        isVisit[0] = true;

        for(int i =0; i< numberOfLine; i++){
            String[] str = br.readLine().split(" ");

            int s = Integer.parseInt(str[0]);
            int g = Integer.parseInt(str[1]);

            lines[s][g] = true;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        isVisit[1] = true;

        int cnt =0;
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=1; i<numberOfCom+1; i++){
                if(isVisit[i] == true) continue;
                if(lines[i][now] || lines[now][i]){
                    isVisit[i]=true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
