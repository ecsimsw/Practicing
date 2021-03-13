package 프로그래머스.codingTest.SM2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SM2_1 {
    static int n;
    static int[][] board;
    static int[] lrbu = new int[]{0, 1, 2, 3};
    static boolean[][] used;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        used = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int r = func(board, n, n);
        System.out.println(r);
    }

    static int func(int[][] leftBoard, int x_size, int y_size) {
        if (x_size == 1 && y_size == 1) {
            System.out.println(max);
            return 0;
        }

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int result = check(leftBoard, x_size, y_size, i);
            System.out.println(result);
            max = Math.max(max, result);
        }

        return max;
    }

    static int check(int[][] leftBoard, int x_size, int y_size, int i) {
        if (i == 0) {
            if (x_size == 1) {
                return 0;
            }

            int[][] left = new int[y_size][x_size / 2];

            int score = 0;
            for (int y = 0; y < y_size; y++) {
                for (int x = 0; x < x_size / 2; x++) {
                    score += leftBoard[y][x];
                    left[y][x] = leftBoard[y][x + x_size / 2];
                }
            }

            return score += func(left, x_size / 2, y_size);
        }

        if (i == 1) {
            if (x_size == 1) {
                return 0;
            }

            int[][] left = new int[y_size][x_size / 2];

            int score = 0;
            for (int y = 0; y < y_size; y++) {
                for (int x = 0; x < x_size / 2; x++) {
                    score += leftBoard[y][x + x_size / 2];
                    left[y][x] = leftBoard[y][x];
                }
            }

            return score += func(left, x_size / 2, y_size);
        }

        if (i == 2) {
            if (y_size == 1) {
                return 0;
            }

            int[][] left = new int[y_size / 2][x_size];

            int score = 0;
            for (int y = 0; y < y_size / 2; y++) {
                for (int x = 0; x < x_size; x++) {
                    score += leftBoard[y][x];
                    left[y][x] = leftBoard[y + y_size / 2][x];
                }
            }

            return score += func(left, x_size, y_size / 2);
        }

        if (i == 3) {
            if (y_size == 1) {
                return 0;
            }

            int[][] left = new int[y_size / 2][x_size];

            int score = 0;
            for (int y = 0; y < y_size / 2; y++) {
                for (int x = 0; x < x_size; x++) {
                    score += leftBoard[y + y_size / 2][x];
                    left[y][x] = leftBoard[y][x];
                }
            }

            return score += func(left, x_size, y_size / 2);
        }

        return 0;
    }
}

/*
4
1 3 4 5
6 2 9 9
4 3 10 5
5 2 8 6
 */


















