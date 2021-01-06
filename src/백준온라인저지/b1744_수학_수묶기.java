package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1744_수학_수묶기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        boolean[] isUsed = new boolean[n];
        int sum=0;
        for(int i =0; i<n; i++){
            if(arr[i])
        }

        System.out.print(sum);
    }
}
