package 백준온라인저지.동적계획;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11048_동적계획법_이동하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            nums = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(nums[j]);
            }
        }

        dpBoard = new int[n][m];

        dp();

        System.out.print(dpBoard[n - 1][m - 1]);
    }

    private static int[][] board;
    private static int[][] dpBoard;

    private static int n;
    private static int m;

    private static void dp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dpBoard[i][j] = board[i][j] + getMax(i, j);
            }
        }
    }

    private static int getMax(int s, int g) {
        int up = 0;
        int left = 0;
        int diagonal = 0;

        if (s - 1 >= 0) {
            up = dpBoard[s - 1][g];
        }

        if (g - 1 >= 0) {
            left = dpBoard[s][g - 1];
        }

        if (s - 1 >= 0 && g - 1 >= 0) {
            diagonal = dpBoard[s - 1][g - 1];
        }

        return Math.max(Math.max(up, left), diagonal);
    }
}

class b11048_동적계획법_이동하기_메모리초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            nums = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(nums[j]);
            }
        }

        dpBoard = new int[n][m];

        bfs(0, 0);

        System.out.print(dpBoard[n - 1][m - 1]);
    }

    private static int[][] board;
    private static int[][] dpBoard;

    private static int[] move_s = new int[]{1, 0, 1};
    private static int[] move_g = new int[]{0, 1, 1};

    private static int n;
    private static int m;

    private static void bfs(int s, int g) {

        LinkedList<Integer> queue_s = new LinkedList<>();
        LinkedList<Integer> queue_g = new LinkedList<>();

        queue_s.offer(s);
        queue_g.offer(g);

        dpBoard[0][0] = board[0][0];

        while (!queue_s.isEmpty()) {

            s = queue_s.poll();
            g = queue_g.poll();

            for (int i = 0; i < 3; i++) {
                int next_s = s + move_s[i];
                int next_g = g + move_g[i];

                if (next_s >= n || next_g >= m) {
                    continue;
                }

                dpBoard[next_s][next_g] = Math.max(
                        dpBoard[next_s][next_g],
                        board[next_s][next_g] + dpBoard[s][g]
                );

                queue_s.offer(next_s);
                queue_g.offer(next_g);
            }
        }
    }
}
