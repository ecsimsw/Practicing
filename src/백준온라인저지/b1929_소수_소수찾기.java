package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1929_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numstr = br.readLine().split(" ");

        int M = Integer.parseInt(numstr[0]);
        int N = Integer.parseInt(numstr[1]);

        boolean[] notPrime = new boolean[1000001];

        StringBuilder sb = new StringBuilder();

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

        if(M<3 && N>=2) System.out.println("2");
        for(int i=M; i<=N; i++ ) {
            if(i==1) continue;
            if(notPrime[i]==false && i%2!=0){
                System.out.println(i);
            }
        }
    }
}
