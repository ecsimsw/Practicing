package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1744_구현_수묶기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        n = 7;
        arr = new int[]{-1, -1, 2, 3, 4, 6, 7};

        Arrays.sort(arr);

        boolean[] isUsed = new boolean[n];
        int sum = 0;

        // 음수부터 0까지
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > 0) {
                break;
            }

            if (isUsed[i] == true) {
                continue;
            }

            if (arr[i] * arr[i + 1] >= 0) {
                isUsed[i] = true;
                isUsed[i + 1] = true;
                sum += (arr[i] * arr[i + 1]);
            }
        }

        // 양수 큰 수부터 2까지
        for (int j = arr.length - 1; j > 0; j--) {
            if (arr[j] < 2 || arr[j - 1] < 2) {
                break;
            }

            if (isUsed[j] == true) {
                continue;
            }

            sum += (arr[j] * arr[j - 1]);
            isUsed[j] = true;
            isUsed[j - 1] = true;
        }

        // 사용 안된 수 더하기
        for (int i = 0; i < n; i++) {
            if (isUsed[i] == true) {
                continue;
            }
            sum += arr[i];
        }

        System.out.print(sum);
    }
}
