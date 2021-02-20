package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2567_구현_색종이 {
    static boolean[][] board = new boolean[102][102];
    static int line = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            drawBox(y, x);
        }

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    line++;
                }

                if (board[i][j] != board[i + 1][j]) {
                    line++;
                }
            }
        }

        System.out.println(line);
    }

    static void drawBox(int y, int x) {
        for (int i = x; i < x + 10; i++) {
            for (int j = y; j < y + 10; j++) {
                board[j + 1][i + 1] = true;
            }
        }
    }
}
