package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2567_구현_색종이 {
    static boolean[][] board = new boolean[101][101];
    static int already = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            draw(x, y);
        }

        System.out.println(40 * n - already * 2);
    }

    static void draw(int y, int x) {

        for (int i = x; i < 10; i++) {
            if (board[y][x + i] == true) {
                System.out.println(y + " " + x + i);
                already++;
            }
        }

        for (int i = x; i < 10; i++) {
            if (board[y + 10][x + i] == true) {
                System.out.println((y + 10) + " " + x + i);
                already++;
            }
        }

        for (int i = y; i < 10; i++) {
            if (board[y + i][x] == true) {
                System.out.println(y + i + " " + x);
                already++;
            }
        }

        for (int i = y; i < 10; i++) {
            if (board[y + i][x + 10] == true) {
                System.out.println(y + i + " " + (x + 10));
                already++;
            }
        }

        for (int i = x; i < x + 10; i++) {
            for (int j = y; j < y + 10; j++) {
                board[j][i] = true;
            }
        }
    }
}
