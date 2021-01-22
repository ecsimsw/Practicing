package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2010_구현_플러그 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum =0;
        for(int i =0; i<n; i++){
            sum += Integer.parseInt(br.readLine());
        }

        System.out.print(sum - n+1);
    }
}
