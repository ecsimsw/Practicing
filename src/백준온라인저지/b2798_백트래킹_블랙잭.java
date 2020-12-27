package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2798_백트래킹_블랙잭 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        String[] line = br.readLine().split(" ");
        n= Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);

        String[] numbers = br.readLine().split(" ");

        arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }

        func(new int[3], 0, 0);
        System.out.print(score);
    }

    static int[] arr;
    static int n;
    static int s;
    static int score =0;

    static int func(int[] set, int setIndex, int arrIndex){

        if(setIndex == 3){
            int sum =0;
            for(int s : set){ sum+=s;}
            return sum;
        }

        int result =0;

        for(int i=arrIndex; i<n; i++){
            set[setIndex] = arr[i];
            result = func(set, setIndex+1, i+1);

            if(result <= s){ if(result>score){ score =result; } }
        }

        return result;
    }
}
