package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1182_백트래킹_부분수열의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        for(int i =0; i<n; i++){
            S_arr[i]= Integer.parseInt(str[i]);
        }
        Arrays.sort(S_arr);

        System.out.print(sol());
    }

    static int n;
    static int[] S_arr;
    static int S;

    static int sol(){
        int result =0;

        for(int i=n; i>-1; i--){
            result += func(new int[i], 0);
        }

        return result;
    }

    static int func(int[] arr, int index){
        if(arr.length-index ==0) return 0;

        int result=0;
        if(index==0){
            arr[0] = S_arr[n-arr.length];
            index++;
            if(arr[0] == S) result++;
        }
        for(int i=n-arr.length+1; i<n; i++){
            if(arr[index-1] >= S_arr[i]) continue;
            arr[index] = S_arr[i];

            int sum =0;
            for(int num : arr){ sum+=num; }
            if(sum == S) result++;

            result += func(arr, index+1);
            arr[index] = 0;
        }

        return result;
    }
}
