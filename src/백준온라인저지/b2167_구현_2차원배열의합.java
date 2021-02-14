package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2167_구현_2차원배열의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int asks[] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum = 0;
            for (int s = asks[0] - 1; s < asks[2]; s++) {
                for (int g = asks[1] - 1; g < asks[3]; g++) {
                    sum += board[s][g];
                }
            }
            System.out.println(sum);
        }
    }
}