package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b4153{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if(a==0&&b==0&&c==0) break;

            boolean r1 = Math.pow(a,2) == Math.pow(b,2)+Math.pow(c,2);
            boolean r2 = Math.pow(b,2) == Math.pow(a,2)+Math.pow(c,2);
            boolean r3 = Math.pow(c,2) == Math.pow(a,2)+Math.pow(b,2);

            if(r1 || r2 || r3) sb.append("right \n");
            else sb.append("wrong \n");
        }

        System.out.print(sb);
    }
}
