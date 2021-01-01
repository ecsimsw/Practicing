package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b13458_구현_시험감독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] person = new int[n];
        String[] personsLine = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            person[i] = Integer.parseInt(personsLine[i]);
        }

        String[] BC = br.readLine().split(" ");
        int b = Integer.parseInt(BC[0]);
        int c = Integer.parseInt(BC[1]);

        Long sum = 0L;

        // 총 시험관 할당
        for (int i = 0; i < person.length; i++) {
            person[i] -= b;
            sum++;
        }

        // 부 시험관 할당
        for (int i = 0; i < person.length; i++) {
            if (person[i] <= 0) {
                continue;
            }

            Long sub = (long) Math.ceil(person[i] / (float) c);
            sum += sub;
        }
        System.out.print(sum);
    }
}
