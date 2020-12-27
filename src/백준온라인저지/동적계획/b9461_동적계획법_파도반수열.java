package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b9461_동적계획법_파도반수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long[] dpBoard = new long[101];

        int cnt = Integer.parseInt(br.readLine());

        int[] nArray = new int[cnt];

        for(int i=0; i<cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            nArray[i] =n;
        }

        dpBoard[1] = 1;
        dpBoard[2] = 1;
        dpBoard[3] = 1;
        dpBoard[4] = 2;
        dpBoard[5] = 2;
        dpBoard[6] = 3;
        dpBoard[7] = 4;
        dpBoard[8] = 5;
        dpBoard[9] = 7;
        dpBoard[10] = 9;

        int j=6;
        for(int i=11; i<=100; i++){
            dpBoard[i] = dpBoard[j++] + dpBoard[i-1];
        }

        for(int n : nArray){
            System.out.println(dpBoard[n]);
        }
    }


}
