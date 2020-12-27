package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1182_백트래킹_부분수열의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        S_arr = new int[n];
        for(int i =0; i<n; i++){ S_arr[i]= Integer.parseInt(str[i]); }

        int r = func(0, 0);
        if(S == 0){ System.out.println(r-1); }
        else { System.out.println(r); }
    }

    static int n;
    static int[] S_arr;
    static int S;

    static int func(int[] set, int index){
        if(index == n) { return 0; }

        int result =0;

        set[index] = S_arr[index];
        func(set, index+1);

        set[index] = 0;
        func(set, index+1);

        return result;
    }


    static int func(int sum, int index){
        if(index == n) {
            if(sum == S)
                return 1;
            else
                return 0;
        }
        int result =0;

        result += func(sum + S_arr[index], index+1);
        result += func(sum, index+1);

        return result;
    }
}
