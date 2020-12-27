package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1966_큐_프린터큐 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int loop=0; loop<N; loop++){
            String[] str = br.readLine().split(" ");
            int m = Integer.parseInt(str[0]);
            int index =Integer.parseInt(str[1]);

            int[] p = new int[10];
            int[] nums = new int[m];

            String[] num = br.readLine().split(" ");
            int max = 0;
            for(int n=0; n<m; n++){
                int priority = Integer.parseInt(num[n]);
                p[priority]++;
                nums[n] = priority;

                if(max < priority) {max = priority;}
            }

            int myIndex =index;
            int cnt =0;

            Queue<Integer> queue = new LinkedList<>();
            for(int i : nums){ queue.offer(i); }

            while(!queue.isEmpty()){
                int peek = queue.poll();

                if(peek == max){
                    cnt++;
                    if(myIndex == 0) { break;}
                    else{ p[max]--; max = findMax(p); }
                }
                else{ queue.offer(peek); }

                myIndex--;
                if(myIndex ==-1){ myIndex = queue.size()-1; }
            }

            sb.append(cnt+"\n");
        }

        System.out.print(sb);
    }

    static int findMax(int[] p){
        for(int i=9; i>0; i--){
            if(p[i] != 0) return i;
        }
        return 0;
    }
}
