package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1085{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);
        int h = Integer.parseInt(str[3]);

        int dif_x= Math.min(x-0,w-x);
        int dif_y = Math.min(y-0, h-y);

        System.out.print(Math.min(dif_x,dif_y));
    }
}
