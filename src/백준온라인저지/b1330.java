package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1330 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split(" ");

        int a= Integer.parseInt(n[0]);
        int b= Integer.parseInt(n[1]);

        if(a==b) System.out.print("==");
        else if(a<b) System.out.print("<");
        else if(a>b) System.out.print(">");
    }
}
