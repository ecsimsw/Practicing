package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class b10610_그리디_30 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("");

        boolean isZero= false;
        for(int i=0; i<numbers.length; i++){
            if(Integer.parseInt(numbers[i]) == 0){
                isZero =true;
                break;
            }
        }
        if(!isZero) {System.out.print("-1"); return;}

        int sum =0;
        for(int i=0; i<numbers.length; i++){
            sum+=Integer.parseInt(numbers[i]);
        }
        if(sum%3!=0) {System.out.print("-1"); return;}

        Arrays.sort(numbers, Collections.reverseOrder());
        for(String s : numbers){
            System.out.print(s);
        }
    }
}
