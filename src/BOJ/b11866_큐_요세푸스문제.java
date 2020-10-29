package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11866_큐_요세푸스문제 {
     public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         String[] strings = br.readLine().split(" ");
         int N = Integer.parseInt(strings[0]);
         int K = Integer.parseInt(strings[1]);

         LinkedList<Integer> queue = new LinkedList<>();
         LinkedList<Integer> queue_result = new LinkedList<>();

         for(int i=1; i<= N; i++) { queue.addLast(i); }

         int point =0;
         while(!queue.isEmpty()){
            point = point+K-1;
            point %= queue.size();
            queue_result.addLast(queue.get(point));
            queue.remove(point);
         }

         System.out.print("<");
         while(queue_result.size()>1){
             System.out.print(queue_result.pollFirst() + ", ");
         }
         System.out.print(queue_result.pollFirst() + ">" );
     }
}
