package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2003_두포인터_수들의합2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int s = Integer.parseInt(strs[1]);

        arr= new int[n];

        strs = br.readLine().split(" ");

        for(int i=0; i<n; i++){ arr[i] = Integer.parseInt(strs[i]); }

        int totalCnt =0;

        int start = 0;
        int end = 0;

        int sum = 0;
        int preSum = arr[0];

        while(true){
            if(start != end){ sum = preSum + arr[end]; }
            else{ sum = preSum; }

            if(sum < s){
                preSum = sum;
                if(end < n ) end++;
            }
            else if(sum == s){
                System.out.println(start + " "+ end);

                totalCnt++;
                preSum = sum - arr[start];
                if(start == end) end++;
                else{ start++; }
            }
            else if(sum > s){
                preSum = sum - arr[start];
                start++;
            }

            if(start >= n || end >= n){
                break;
            }
        }

        System.out.println(totalCnt);
    }

    static int[] arr;

    static int sumWhile(int start, int end){
        int sum =0;
        for(int i = start; i<=end; i++){
            sum += arr[i];
        }
        return sum;
    }
}
