package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15650_백트래킹_N과M2 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 4;
        M = 4;
        func(new int[M], 0, 0);
    }
    static int N;
    static int M;

    static void func(int[] set, int index, int max){
        if(index == M) {
            for(int s : set) System.out.print(s + " ");
            System.out.println();
            return;
        }

        for(int i=1; i<= N; i++){
            if(max<i){
                set[index] = i;
                func(set, index+1, i);
            }
        }
    }
}