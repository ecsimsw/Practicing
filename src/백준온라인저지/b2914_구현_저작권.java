package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2914_구현_저작권 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AI = br.readLine().split(" ");
        int A = Integer.parseInt(AI[0]);
        int I = Integer.parseInt(AI[1]);

        System.out.println(A*(I-1)+1);
    }
}
