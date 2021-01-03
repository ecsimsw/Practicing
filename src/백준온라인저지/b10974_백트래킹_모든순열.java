package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10974_백트래킹_모든순열 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        isUsed = new boolean[n + 1];

        makePerm(0, n, new StringBuilder());

        System.out.print(sb.toString());
    }

    private static boolean[] isUsed;

    private static void makePerm(int i, int n, StringBuilder line) {
        if (i == n) {
            sb.append(line.toString() + "\n");
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (isUsed[num] == false) {
                line.append(num + " ");
                isUsed[num] = true;
                makePerm(i + 1, n, line);
                isUsed[num] = false;
                line.delete(line.length() - 2, line.length());
            }
        }
    }
}
