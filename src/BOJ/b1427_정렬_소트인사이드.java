package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1427_정렬_소트인사이드 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 0 ~ 9
        int[] numbers = new int[10];

        while(n > 0){
            numbers[n%10]++;
            n = n /10;
        }

        for(int i = 9; i>-1; i--){
            for(int count=0; count<numbers[i]; count++){
                System.out.print(i);
            }
        }
    }
}