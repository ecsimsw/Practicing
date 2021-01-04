package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2294_동적계획법_동전2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);

        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int[] price = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            price[i] = i;
        }

        int[] dpBoard = new int[k + 1];
        Arrays.fill(dpBoard, -1);
        dpBoard[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - money[i] < 0) {
                    continue;
                }

                if (j / money[i] != 0) {
                    continue;
                }

                dpBoard[j] = dpBoard[j] + dpBoard[j - money[i]];
            }

            for (int d = 0; d <= k; d++) {
                System.out.print(dpBoard[d] + " ");
            }

            System.out.println();
        }

        for (int i = 0; i <= k; i++) {
            System.out.print(dpBoard[i] + " ");
        }
    }
}

class b2294_동적계획법_동전2_문제잘못파악 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);

        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int[] price = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            price[i] = i;
        }

        int[] dpBoard = new int[k + 1];
        Arrays.fill(dpBoard, -1);
        dpBoard[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - money[i] < 0) {
                    continue;
                }

                if (dpBoard[j] == -1 && dpBoard[j - money[i]] == -1) {
                    dpBoard[j] = -1;
                    continue;
                }

                if (dpBoard[j - money[i]] == -1) {
                    continue;
                }

                if (dpBoard[j] == -1) {
                    dpBoard[j] = 0;
                }

                dpBoard[j] = dpBoard[j] + dpBoard[j - money[i]];
            }

            for (int d = 0; d <= k; d++) {
                System.out.print(dpBoard[d] + " ");
            }

            System.out.println();
        }

        for (int i = 0; i <= k; i++) {
            System.out.print(dpBoard[i] + " ");
        }
    }
}
