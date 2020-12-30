package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class b2576_구현_홀수 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> odds = new LinkedList<>();

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num % 2 != 0) {
                odds.add(num);
            }
        }

        Collections.sort(odds);

        if (odds.size() == 0) {
            System.out.println("-1");
            return;
        }

        int sum = odds.stream()
                .mapToInt(i -> i)
                .sum();

        int min = odds.get(0);

        System.out.println(sum);
        System.out.println(min);
    }
}
