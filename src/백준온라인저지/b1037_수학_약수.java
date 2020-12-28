package 백준온라인저지;

import javax.annotation.processing.Completion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class b1037_수학_약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        Integer[] nums = new Integer[strs.length];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(nums, Collections.reverseOrder());

        int max = nums[0];
        int min = nums[nums.length - 1];

        System.out.print(max * min);
    }
}
