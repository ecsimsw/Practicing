package BOJ;

import java.io.*;
import java.util.*;

public class b2271_그리디_로프 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr,Collections.reverseOrder());

        int max = arr[0];
        int cnt = 1;

        for(int i=cnt; i<n; i++){
            cnt++;
            if(arr[i]*cnt>max){
                max = arr[i]*cnt;
            }
        }

        System.out.print(max);
    }
}
