package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1074_재귀_Z {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        d_s = Integer.parseInt(str[1]);
        d_g = Integer.parseInt(str[2]);

        int n = z((int)Math.pow(2,N),0,0);

        System.out.println(n);
    }

    static int d_s =0;
    static int d_g =0;
    static int n=0;

    static int z(int count, int s, int g){
        if(count == 1){
            if(s == d_s && g == d_g){
                return n;
            }
            n++;
            return 0;
        }
        count /= 2;

        int r=0;

        r += z(count,s,g);
        r += z(count,s,g+count);
        r += z(count,s+count, g);
        r += z(count,s+count, g+count);

        return r;
    }
}