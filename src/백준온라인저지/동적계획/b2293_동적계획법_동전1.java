package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class b2293_동적계획법_동전1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);

        units = new Integer[n];

        for (int i = 0; i < n; i++) {
            units[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(units, Collections.reverseOrder());

        dpBoard = new int[k + 1];

        dp(k);

        for (int i : dpBoard) {
            System.out.print(i + "  ");
        }
    }

    private static int[] dpBoard;
    private static Integer[] units;

    private static int dp(int money) {
        if (dpBoard[money] != 0) {
            return dpBoard[money];
        }

        int count = 0;
        for (int unit : units) {
            if (money < unit) {
                continue;
            }

            if (unit == money) {
                count += 1;
                continue;
            }

            if (unit < money - unit) {
                count += dp(unit);
                continue;
            }
            count += (dp(unit) + dp(money - unit));
        }

        dpBoard[money] = count;
        return count;
    }
}
