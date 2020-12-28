package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2455_구현_지능형기차 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            String[] AB = br.readLine().split(" ");
            n += Integer.parseInt(AB[1]);
            n -= Integer.parseInt(AB[0]);
            max = Math.max(n, max);
        }

        System.out.print(max);
    }
}
