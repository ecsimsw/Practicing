package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class b1260_bfs_dfs_DFS와BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int lineCount = Integer.parseInt(str[1]);
        int startNode= Integer.parseInt(str[2]);

        boolean[][] lines_dfs = new boolean[n+1][n+1];
        boolean[][] lines_bfs = new boolean[n+1][n+1];
        boolean[] checker_dfs = new boolean[n+1];
        boolean[] checker_bfs = new boolean[n+1];
        checker_dfs[0] =true;
        checker_bfs[0] =true;

        for(int i =0; i<lineCount; i++){
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int g = Integer.parseInt(line[1]);

            lines_bfs[s][g] = true;
            lines_dfs[s][g] = true;
        }

        Stack<Integer> stack = new Stack<>();

stack.push(startNode);
sb.append(startNode+" ");
checker_dfs[startNode] = true;

while(!stack.isEmpty()){
    int point = stack.peek();
    int next =0;
    for(int i = 1; i<=n; i++){
        if(checker_dfs[i]== false ){
            if(lines_dfs[point][i] || lines_dfs[i][point]){
                next= i;
                break;
            }
        }
    }

    if(next ==0 ){
        stack.pop();
    }
    else{
        checker_dfs[next] = true;
        stack.push(next);
        sb.append(next+" ");
    }
}
sb.append("\n");

Queue<Integer> queue = new LinkedList<>();

queue.offer(startNode);
checker_bfs[startNode] = true;
sb.append(startNode + " ");

while(!queue.isEmpty()){
   int point = queue.poll();

   for(int i=1; i<n+1; i++){
       if(checker_bfs[i] == false){
           if(lines_bfs[i][point] || lines_bfs[point][i]){
               queue.offer(i);
               checker_bfs[i] =true;
               sb.append(i+" ");
           }
       }
   }
}
System.out.print(sb);
    }
}