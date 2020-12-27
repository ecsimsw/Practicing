package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b2581_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[10001];

        for(int i=3; i<=N; i++){
            if(i%2 ==0) continue;
            if(notPrime[i]==true) continue;

            int m = 3;
            while(true){
                if(i*m > N) break;
                notPrime[i*m] = true;
                m+=2;
            }
        }
        int min=10000;
        int sum=0;
        if(M<3 && N>=2){
            //System.out.println("2");
            min =2;
            sum =2;
        }
        for(int i=M; i<=N; i++ ) {
            if(i==1) continue;
            if(notPrime[i]==false && i%2!=0){
                if(min>i) min =i;
                sum+=i;
            }
        }

        if(sum == 0){
            System.out.print("-1");
            return;
        }

        System.out.println(sum);
        System.out.print(min);
    }
}
