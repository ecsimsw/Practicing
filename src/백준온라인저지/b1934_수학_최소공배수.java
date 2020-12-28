package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1934_수학_최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            System.out.println(a * b / getGCD(a, b));
        }
    }

    private static int getGCD(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        }

        if (a > b) {
            return getGCD(a - b, b);
        } else if (b > a) {
            return getGCD(a, b - a);
        } else {
            return a;
        }
    }
}
