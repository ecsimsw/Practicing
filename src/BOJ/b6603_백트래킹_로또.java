package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b6603_백트래킹_로또 {
    public static void main(String []args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            if(n==0) break;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i + 1]);
            }
            func(new int[6],0,0,0);
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.print(sb);
    }

    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void func(int[] set, int setIndex, int arrIndex, int count){
        if(count == 6){
            for(int j : set) sb.append(j +" ");
            sb.append("\n");
            return;
        }

        if(6-setIndex == n-arrIndex) {
            set[setIndex] = arr[arrIndex];
            func(set, setIndex+1, arrIndex+1, count+1);
        }
        else{
            set[setIndex] = arr[arrIndex];
            func(set, setIndex+1, arrIndex+1, count+1);
            func(set, setIndex, arrIndex+1, count);
        }
    }
}
