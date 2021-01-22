package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1715_우선순위큐_카드정렬하기 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i =0; i<n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        if(queue.size() == 1){
            System.out.print(0);
            return;
        }

        int count = 0;
        while(!queue.isEmpty()){
            int smallest = queue.poll();

            if(queue.isEmpty()){
                count += smallest;
                break;
            }

            int seconSmallest = queue.poll();
            int sum = smallest + seconSmallest;
            count += sum;

            if(queue.isEmpty()){
                break;
            }

            queue.offer(sum);
        }

        System.out.print(count);
    }
}
