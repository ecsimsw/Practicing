package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b3042_구현_R2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] R1S = br.readLine().split(" ");

        int R1 = Integer.parseInt(R1S[0]);
        int S = Integer.parseInt(R1S[1]);

        int sum = S * 2;
        int R2 = sum - R1;
        System.out.print(R2);
    }
}
