package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2475_검증수 {
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int sum =0;
        int a =0;
        for(int i=0; i<5; i++){
            a = Integer.parseInt(s[i]);
            sum += a*a;
        }

        System.out.print(sum%10);

    }
}
