package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2869_구현_달팽이는올라가고싶다 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] str = br.readLine().split(" ");

        int day = 0;
        int v = Integer.parseInt(str[2]);
        int down = Integer.parseInt(str[1]);
        int up = Integer.parseInt(str[0]);
        int position = 0;

        if (v == 0) {
            System.out.print(0);
            return;
        }

        int dif = up-down;

        day += (v-up)/dif;
        position += (dif)*day;

        while (true) {
            day++;
            position += up;
            if (position >= v) {
                break;
            }
            position -= down;
        }

        System.out.print(day);
    }
}
