package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b2446 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = 2*n-1;
        for(int count=0; count<n; count++){
            for(int i=0; i<count; i++){ System.out.print(" "); }
            for(int i=0; i<a -count*2; i++){ System.out.print("*"); }
            System.out.println();
        }
        for(int count=n-2; count>-1; count--){
            for(int i=0; i<count; i++){ System.out.print(" "); }
            for(int i=0; i<a -count*2; i++){ System.out.print("*"); }
            if(count != 0) System.out.println();
        }
    }
}
