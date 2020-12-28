package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11050_수학_이항계수1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);

        int son = 1;
        int temp = n;
        for (int i = 0; i < k; i++) {
            son *= temp--;
        }

        int mom = 1;
        temp = 1;
        for (int i = 0; i < k; i++) {
            mom *= temp++;
        }

        System.out.print(son / mom);
    }
}
