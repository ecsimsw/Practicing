package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1550_API_16진수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine(), 16);
        System.out.print(i);
    }
}
