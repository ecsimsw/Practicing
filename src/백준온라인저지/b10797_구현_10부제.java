package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10797_구현_10부제 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");

        int i = (int) Arrays.stream(nums)
                .map(Integer::parseInt)
                .filter(num -> num == n)
                .count();

        System.out.print(i);
    }
}
