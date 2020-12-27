package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b2523 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a;
        for(a =1; a<n; a++) {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(a =n; a>0; a--) {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
