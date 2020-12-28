package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11057_동적계획법_오르막수 {
    private static int[][] board = new int[1001][10];

    static {
        board[1][0] = 10;
        board[1][1] = 9;  // board[1][0]-1
        board[1][2] = 8;
        board[1][3] = 7;
        board[1][4] = 6;
        board[1][5] = 5;
        board[1][6] = 4;
        board[1][7] = 3;
        board[1][8] = 2;
        board[1][9] = 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(increaseNum(n, 0) % 10007);
    }

    private static int increaseNum(int count, int start) {
        if (board[count][start] != 0) {
            return board[count][start] % 10007;
        }

        int sum = 0;
        for (int i = start; i <= 9; i++) {
            int result = increaseNum(count - 1, i);
            sum += result;
            if (board[count - 1][i] == 0) {
                board[count - 1][i] = sum % 10007;
            }
        }

        board[count][start] = sum % 10007;
        return sum;
    }
}
