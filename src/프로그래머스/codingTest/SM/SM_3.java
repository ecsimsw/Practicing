package 프로그래머스.codingTest.SM;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
2
1 3 1 3 5
2 2 2 4
3 2 1 2
4 1 3
 */
class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int numberOfD = n * n;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numberOfD; i++) {
            String[] nums = sc.nextLine().split(" ");
            int score = Integer.parseInt(nums[0]);
            int count = Integer.parseInt(nums[1]);

            for (int j = 0; j < count; j++) {
                int time = Integer.parseInt(nums[j + 2]);
                int beforeScore = map.getOrDefault(time, 0);
                map.put(time, Integer.max(beforeScore, score));
            }
        }

        int sum = 0;
        for (int i : map.values()) {
            sum += i;
        }

        System.out.println(sum);
    }
}
