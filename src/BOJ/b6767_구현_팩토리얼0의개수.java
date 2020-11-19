package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b6767_구현_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int zeroCnt = 0;

        for(int i=1; i<=n; i++){
            cal(i);
        }

        zeroCnt += ten;
        zeroCnt += Math.min(five, two);

        System.out.println(zeroCnt);
    }

    static int five;
    static int two;
    static int ten;

    static void cal(int i){
        while(true){
            if(i%10 ==0){
                i = i/10;
                ten++;
                continue;
            }
            if(i%5 ==0){
                i = i/5;
                five++;
                continue;
            }
            if(i%2 ==0){
                i = i/2;
                two++;
                continue;
            }

            break;
        }
    }
}
