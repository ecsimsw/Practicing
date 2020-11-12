package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b2588 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int three = n * (m%10);
        int four = n * ((m/10)%10);
        int five = n * ((m/100)%10);

        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(n*m);
    }
}
