package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2231_브루트포스_분해합 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum=0;
        int i= 1;
        boolean finish = false;
        for(i=1; i<n; i++){
            int temp = i;
            sum =i;

            while(temp>0){
                sum += temp%10;
                temp/=10;
            }

            if(sum == n) {
                finish = true;
                break;
            }
        }

        if(!finish) System.out.print("0");
        else{ System.out.print(i); }
    }
}