package 백준온라인저지;

import java.io.*;

public class b2512_이분탐색_예산 {
    public static void main (String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str1[] = br.readLine().split(" ");

        int arr[] = new int[N];

        int max = Integer.parseInt(br.readLine());
        int l = 0;
        int r = 0;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(str1[i]);
            arr[i] = money;
            r = arr[i] > r ? arr[i] : r;
        }

        while (l < r) {
            int sum = 0;
            int m = (l + r + 1) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > m) sum += m;
                else sum += arr[i];
            }
            if (max < sum) r = m - 1;
            else l = m;
        }

        System.out.println(l);
    }
}
