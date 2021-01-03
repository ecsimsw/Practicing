package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2902_구현_KMP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] names = br.readLine().split("-");
        for (String n : names) {
            System.out.print(n.charAt(0));
        }
    }
}
