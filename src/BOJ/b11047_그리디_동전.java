package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11047_그리디_동전 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line =  br.readLine().split(" ");
        int n= Integer.parseInt(line[0]);
        int k= Integer.parseInt(line[1]);
        int[] coins = new int[n];

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt=0;
        int left = k;

        while(left!=0){
            int i;
            for(i=n-1; i>-1; i--) {
                if(coins[i]<=left){
                    break;
                }
            }
            int numberOfCoin =  (left / coins[i]);
            left = left - coins[i]*numberOfCoin;
            cnt += numberOfCoin;
        }

        System.out.print(cnt);
    }
}
