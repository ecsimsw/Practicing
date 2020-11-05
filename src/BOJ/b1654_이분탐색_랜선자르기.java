package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1654_이분탐색_랜선자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int N = Integer.parseInt(strs[1]);

        int[] arr = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>max){ max = arr[i]; }
        }

        long count=0;
        long left = 1;
        long right = max;
        long middle = ( right + left )/2;

        while(left <= right){
            count =0;
            middle = ( right + left )/2;

            for(int index=0; index<n; index++){
                count += arr[index]/middle;
            }
            if(count < N){
                // middle이 더 작아져야함
                right = middle-1;

            }
            else if(count >= N){
                left = middle+1;
            }
        }

        System.out.println(right);

    }
}
