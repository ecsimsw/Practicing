package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2875_구현_대회or인턴 {
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nums = br.readLine().split(" ");

    int n = Integer.parseInt(nums[0]);
    int m = Integer.parseInt(nums[1]);
    int k = Integer.parseInt(nums[2]);

    int ableToMake = 0;
    while (true) {
        if (n < 2 || m < 1) {
            break;
        }

        n -= 2;
        m -= 1;
        ableToMake++;
    }

    int leftPerson = n + m;

    if (k <= leftPerson) {
        System.out.print(ableToMake);
        return;
    }

    k -= leftPerson;

    // 1 -> 1
    // 2 -> 1
    // 3 -> 1
    // 4 -> 2
    // 5 -> 2
    // 6 -> 2
    // 7 -> 3

    ableToMake -= (int) Math.floor((k - 1) / 3) + 1;
    System.out.print(ableToMake);
}
}
