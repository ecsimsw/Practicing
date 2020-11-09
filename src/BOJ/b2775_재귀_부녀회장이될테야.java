package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2775_재귀_부녀회장이될테야 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        apart =new int[15][15];

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            sb.append(func(a,b)+"\n");
        }

        System.out.print(sb);
    }
    static int[][] apart;

    static int func(int a, int b){
        if(apart[a][b] != 0) return apart[a][b];

        if(a==0){
            apart[0][b] = b;
            return b;
        }

        int person =0;
        for(int i =1; i<=b; i++){
            person += func(a-1,i);
        }

        apart[a][b] = person;

        return person;
    }
}