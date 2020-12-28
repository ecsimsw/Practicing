package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b10026_bfs_적록색약 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new String[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split("");
        }

        int normal = search(false);
        int weaker = search(true);

        System.out.print(normal + " " + weaker);
    }

    private static int search(boolean isWeaker) {
        isUsed = new boolean[n][n];
        int section = 0;

        int s;
        int g;

        for (s = 0; s < n; s++) {
            for (g = 0; g < n; g++) {
                if (isUsed[s][g] == false) {
                    bfs(s, g, isWeaker);
                    section++;
                }
            }
        }
        return section;
    }

    private static int[] move_s = new int[]{0, 0, 1, -1};
    private static int[] move_g = new int[]{1, -1, 0, 0};

    private static String[][] board;
    private static boolean[][] isUsed;

    private static int n;

    private static void bfs(int s, int g, boolean isWeaker) {
        String find = board[s][g];

        LinkedList<Integer> queue_s = new LinkedList<>();
        LinkedList<Integer> queue_g = new LinkedList<>();

        queue_s.offer(s);
        queue_g.offer(g);
        isUsed[s][g] = true;

        while (!queue_s.isEmpty()) {
            s = queue_s.poll();
            g = queue_g.poll();

            for (int i = 0; i < 4; i++) {
                int next_s = s + move_s[i];
                int next_g = g + move_g[i];

                if (next_s < 0 || next_g < 0 || next_s >= n || next_g >= n) {
                    continue;
                }

                if (isUsed[next_s][next_g] == false
                        && isEquals(find, board[next_s][next_g], isWeaker)) {
                    queue_s.offer(next_s);
                    queue_g.offer(next_g);
                    isUsed[next_s][next_g] = true;
                }
            }
        }
    }

    private static boolean isEquals(String find, String color, boolean isWeaker) {
        if (isWeaker) {
            if (find.equals("B") && color.equals("B")) {
                return true;
            }

            if (!find.equals("B") && !color.equals("B")) {
                return true;
            }
        }
        return find.equals(color);
    }
}
