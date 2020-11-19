package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2003_두포인터_수들의합2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int s = Integer.parseInt(strs[1]);

        int[] arr= new int[n];

        strs = br.readLine().split(" ");

        for(int i=0; i<n; i++){ arr[i] = Integer.parseInt(strs[i]); }

        int totalCnt =0;

        int start = 0;
        int end = 0;

        int sum = arr[0];

        while(true){
            System.out.println(start+ " "+ end +" "+sum );
            if(sum == s){
                totalCnt++;

                sum -= arr[start];
                start++;
                end++;
                if(end < n){ sum+= arr[end]; }
            }
            else if(sum < s){
                end++;
                if(end < n){ sum += arr[end]; }
                else{
                    sum -= arr[start];
                    start++;
                }
            }
            else if(sum > s){
                sum -= arr[start];
                start++;
            }

            if(start >= n ){ break; }
        }

        System.out.println(totalCnt);
    }
}
