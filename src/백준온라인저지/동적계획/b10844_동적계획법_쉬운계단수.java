package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10844_동적계획법_쉬운계단수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dpBoard = new long[100][10];

        for(int i=1; i<10; i++){
            dp(n-1,i);
        }

        long sum=0;
        for(int j=0; j<10; j++){
            sum += (dpBoard[n-1][j]);
        }
        System.out.print(sum%1000000000);
    }

    static int n;
    static long[][] dpBoard;

    static long dp(int index, int num){
        if(dpBoard[index][num]!=0){
            return dpBoard[index][num];
        }

        if(index ==n-1 && num ==0){
            return 0;
        }
        else if(index==0){
            dpBoard[index][num] = 1;
            return 1;
        }

        if(num ==0){
            dpBoard[index][num] = dp(index-1, 1)%1000000000;
        }
        else if(num ==9){
            dpBoard[index][num] = dp(index-1, 1)%1000000000;
        }
        else{
            dpBoard[index][num] =(dp(index-1, num-1) + dp(index-1, num+1))%1000000000;
        }

        return dpBoard[index][num];
    }

}
