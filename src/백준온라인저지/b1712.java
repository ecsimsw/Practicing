package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1712 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        if(c-b<1){
            System.out.print("-1");
            return;
        }
        int n = (a/(c-b))+1;
        System.out.print(n);
    }
}
