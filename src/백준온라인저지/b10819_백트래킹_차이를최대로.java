package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b10819_백트래킹_차이를최대로 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nums = new int[n];
        isUsed = new boolean[n];

        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        makeSum(0, 0, 0);

        System.out.print(max);
    }

    private static int max = 0;
    private static int[] nums;
    private static boolean[] isUsed;
    private static LinkedList<Integer> list = new LinkedList<>();

    private static void makeSum(int n, int before, int sum) {
        if (n == nums.length) {
            max = Math.max(max, sum);
            return;
        }

        if (n == 0) {
            for (int i = 0; i < nums.length; i++) {
                isUsed[i] = true;
                makeSum(1, nums[i], 0);
                isUsed[i] = false;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }

            isUsed[i] = true;
            list.addLast(nums[i]);
            makeSum(n + 1, nums[i], sum + Math.abs(before - nums[i]));
            list.removeLast();
            isUsed[i] = false;
        }
    }

    private static boolean isDuplicated(LinkedList<Integer> list) {
        return list.size() != list.stream()
                .distinct()
                .count();
    }
}
