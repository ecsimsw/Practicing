package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class b1476_구현_날짜계산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int E = Integer.parseInt(nums[0]);
        int S = Integer.parseInt(nums[1]);
        int M = Integer.parseInt(nums[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int year = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                break;
            }

            e++;
            if (e == 16) {
                e = 1;
            }

            s++;
            if (s == 29) {
                s = 1;
            }

            m++;
            if (m == 20) {
                m = 1;
            }
            year++;
        }

        System.out.print(year);
    }
}


class b1476_구현_날짜계산_시간초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int E = Integer.parseInt(nums[0]);
        int S = Integer.parseInt(nums[1]);
        int M = Integer.parseInt(nums[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int dif = S - s;
        int year = 1 + dif;

        e += dif;
        e %= 15;

        s += dif;
        s %= 28;

        m += dif;
        m %= 19;

        while (true) {
            if (e == E && s == S && m == M) {
                break;
            }

            e += 28;
            e %= 15;

            s += 28;
            s %= 28;

            m += 28;
            m %= 19;

            year += 28;
        }

        System.out.print(year);
    }
}
