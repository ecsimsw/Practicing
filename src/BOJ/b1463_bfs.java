package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class b1463_bfs{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int cnt=0;
        boolean finish= false;
        while(true){
            int cycle = queue.size();
            for(int i=0; i<cycle; i++) {
                n = queue.poll();
                if (n == 1) {
                    finish =true;
                    break;
                }

                if (n % 3 == 0) queue.offer(n / 3);
                if (n % 2 == 0) queue.offer(n / 2);
                queue.offer(n - 1);
            }
            if(finish) break;
            cnt++;
        }
        System.out.print(cnt);
    }
}
