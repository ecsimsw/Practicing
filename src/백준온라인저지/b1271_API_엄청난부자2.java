package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class b1271_API_엄청난부자2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        BigInteger n = new BigInteger(NM[0]);
        BigInteger m = new BigInteger(NM[1]);

        BigInteger divide = n.divide(m);
        BigInteger left = n.subtract(m.multiply(divide));

        System.out.println(divide);
        System.out.print(left);
    }
}
