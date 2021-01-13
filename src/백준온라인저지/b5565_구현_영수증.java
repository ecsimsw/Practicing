package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b5565_구현_영수증 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.parseInt(br.readLine());

        for(int i=0; i<9; i++){
            sum -= Integer.parseInt(br.readLine());
        }

        System.out.println(sum);
    }
}
