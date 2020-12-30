package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b1094_구현_막대기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> barList = new LinkedList<>();
        barList.add(64);

        int sum = barList.get(0);
        while (sum > n) {
            int smallest = barList.get(barList.size() - 1);
            barList.remove(barList.size() - 1);
            barList.add(smallest / 2);
            barList.add(smallest / 2);

            if (sum - (smallest / 2) >= n) {
                barList.remove(barList.size() - 1);
                sum -= smallest / 2;
            }
        }

        System.out.print(barList.size());
    }
}
