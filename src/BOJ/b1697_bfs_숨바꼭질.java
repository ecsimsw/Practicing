package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1697_bfs_숨바꼭질 {
    static public void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        boolean[] checker = new boolean[100001];
        checker[N] = true;
        queue.offer(N);

        int X =N;
        int n =0;
        int queueSize;
        boolean finish = false;

        if(X==K){
            System.out.println(n);
            System.exit(0);
        }


        while(X!=K){
            queueSize =queue.size();
            for(int i=0; i<queueSize; i++){
                X = queue.poll();

                if(X+1<=100000){
                    if(X+1 == K) finish=true;
                    if(checker[X+1] == false) {
                        checker[X+1] = true;
                        queue.offer(X+1);
                    }
                }
                if(X-1>=0){
                    if(X-1 == K) finish=true;
                    if(checker[X-1] == false) {
                        checker[X-1] = true;
                        queue.offer(X-1);
                    }
                }
                if(2*X <=100000){
                    if(2*X == K) finish=true;
                    if(checker[2*X] == false) {
                        checker[2*X] = true;
                        queue.offer(2*X);
                    }
                }
            }
            n++;

            if(finish) break;
        }
        System.out.println(n);
    }
}
