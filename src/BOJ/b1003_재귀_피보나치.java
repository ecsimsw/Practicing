package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1003_재귀_피보나치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        zeroCnt = new int[45];
        oneCnt = new int[45];

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i =0; i<n; i++){
            nums[i] =  Integer.parseInt(br.readLine());
        }
        for(int i =0; i<n; i++) {
            System.out.print(funcZero(nums[i])+" ");
            System.out.println(funcOne(nums[i]));
        }
    }

    static int[] zeroCnt;
    static int[] oneCnt;

    static int funcOne(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n==2) return 1;
        else if(n==3) return 2;
        else if(n==4) return 3;

        if(oneCnt[n]!=0) return oneCnt[n];

        int result =  funcOne(n-1) + funcOne(n-2);
        oneCnt[n] = result;
        return result;
    }

    static int funcZero(int n){
        if(n==0) return 1;
        else if(n==1) return 0;
        else if(n==2) return 1;
        else if(n==3) return 1;
        else if(n==4) return 2;

        if(zeroCnt[n]!=0) return zeroCnt[n];

        int result =  funcZero(n-1) + funcZero(n-2);
        zeroCnt[n] = result;
        return result;
    }
}
