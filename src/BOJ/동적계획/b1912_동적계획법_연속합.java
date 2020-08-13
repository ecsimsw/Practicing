package BOJ.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1912_동적계획법_연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] strings = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(strings[i]);
        }

        long[] dpBoard = new long[n];

        dpBoard[0] = nums[0];
        for(int i=1; i<n; i++){
            if(dpBoard[i-1] < 0){
                dpBoard[i] = nums[i];
            }
            else{
                dpBoard[i] = dpBoard[i-1]+nums[i];
            }
        }

        long max =-1001;
        for(long i: dpBoard){
            if(max < i ) max=i;
        }
        System.out.print(max);
    }
}
