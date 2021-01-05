package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class b10757_API_큰수AB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] AB = br.readLine().split(" ");
        BigInteger A = new BigInteger(AB[0]);
        BigInteger B = new BigInteger(AB[1]);

        System.out.print(A.add(B));
    }
}
