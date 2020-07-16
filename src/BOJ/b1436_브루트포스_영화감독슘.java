package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1436_브루트포스_영화감독슘 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String six = "666";

        int i = 665;
        int n =0;
        while(true){
            if(String.valueOf(i).contains(six)) n++;

            if(n==N) break;

            i++;
        }

        System.out.print(i);
    }
}
