package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15651_백트래킹_N과M3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        func(new int[M], 0);

        System.out.print(sb);
    }

    static int N;
    static int M;

    static int[] arr;
    static StringBuilder sb;

    static void func(int[] set, int count){
        if(count == M){
            for(int s : set){ sb.append(s+" "); }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            set[count] = i;
            func(set,count+1);
        }
    }
}
