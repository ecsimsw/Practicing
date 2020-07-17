package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class B3052 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers =new int[9];

        for(int i=0; i<9; i++){
            int a =Integer.parseInt(br.readLine());
            numbers[i] = a;
        }

        int max=0;
        int index =0;
        for(int i=0; i<9; i++){
            if(max < numbers[i]){
                index=i;
                max = numbers[i];
            }
        }
        System.out.println(max);
        System.out.print(index+1);
    }
}