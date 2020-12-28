package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10953_AB6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(",");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            System.out.println(a + b);
        }
    }
}
