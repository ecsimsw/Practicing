package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1977_구현_완전제곱수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        /// 범위를 확인해야하는 문제.
        /// to가 10000으로 100의 제곱 수 까지 밖에 안되니까 미리 제곱 수 계산을 해두자.

        int[] arr = new int[101];

        for (int i = 1; i <= 100; i++) {
            arr[i] = i * i;
        }

        int fromIndex = 0;

        // search from
        for (int i = 1; i <= 100; i++) {
            if (arr[i] >= from) {
                fromIndex = i;
                break;
            }
        }

        int toIndex = 101;
        // search to
        for (int i = 100; i > 0; i--) {
            if (arr[i] <= to) {
                toIndex = i;
                break;
            }
        }

        if (fromIndex == 0 || toIndex == 101 || fromIndex > toIndex) {
            System.out.println("-1");
            return;
        }

        int sum = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
        System.out.println(arr[fromIndex]);
    }
}
