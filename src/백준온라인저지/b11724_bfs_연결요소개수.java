package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11724_bfs_연결요소개수 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int point = Integer.parseInt(strings[0]);
        int line = Integer.parseInt(strings[1]);

        boolean[] visit = new boolean[point+1];

        int[][] board = new int[point+1][point+1];

        for(int i=0; i<line; i++){
            strings = br.readLine().split(" ");
            board[Integer.parseInt(strings[0])][Integer.parseInt(strings[1])] =1;
            board[Integer.parseInt(strings[1])][Integer.parseInt(strings[0])] =1;
        }

        int count =0;
        for(int i=1; i<=point; i++){
            if(visit[i] == false){
                count++;
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                visit[i] = true;

                while(!queue.isEmpty()){
                    int s = queue.poll();

                    for(int next =1; next<=point; next++){
                        if(board[s][next]==1 && visit[next]==false){
                            queue.add(next);
                            visit[next] =true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
