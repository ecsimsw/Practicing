package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;

public class b11399_그리디_ATM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int n= Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] waits = new int[n];

        for(int i =0; i<n; i++){
            waits[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(waits);

        int sum =0;
        int waitTime =0;
        for(int w : waits){
            waitTime += w;
            sum += waitTime;
        }
        System.out.print(sum);
    }
}
