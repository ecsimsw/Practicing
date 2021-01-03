package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;

public class b1339_그리디_단어수학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.fill(counts, 0);

        for (String word : words) {
            getCounts(word);
        }

        Arrays.sort(counts, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (counts[i] * (9 - i));
        }

        System.out.print(sum);
    }

    private static Integer[] counts = new Integer[26];

    private static void getCounts(String word) {
        char[] chars = word.toCharArray();
        int count = 1;
        for (int i = chars.length - 1; i > -1; i--) {
            counts[(int) chars[i] - 65] += count;
            count *= 10;
        }
    }
}
