package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class b1914_재귀_하노이탑 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean needPrint = N>20? false : true;

        if(needPrint){
            System.out.println((int)Math.pow(2,N)-1);
            move(1,3,N);
        }
        else{
            BigInteger two = new BigInteger("2");
            BigInteger bi = two.pow(N).subtract(new BigInteger("1"));
            System.out.println(bi);
        }
    }

    static boolean[] check = new boolean[3];

    static int move(int from, int to, int count){
        if(count ==1){
            System.out.println(from+" "+to);
            return 1;
        }

        check[from-1] = true;
        check[to-1] =true;

        int next =0;

        for(int i =0; i<3; i++){ if(check[i] == false){ next = i+1; } }
        Arrays.fill(check,false);

        int ans =0;

        ans += move(from, next, count-1);

        ans++;
        System.out.println(from+" "+to);

        return ans + move(next, to, count-1);
    }
}