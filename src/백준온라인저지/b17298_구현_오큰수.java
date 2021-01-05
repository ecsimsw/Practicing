package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class b17298_구현_오큰수_시간초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] oNums = new int[n];
        Arrays.fill(oNums, -1);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            int one = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] > one) {
                    oNums[i] = arr[j];
                    break;
                }
            }
        }

        for (int o : oNums) {
            System.out.print(o + " ");
        }
    }
}
