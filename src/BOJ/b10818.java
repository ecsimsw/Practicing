package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b10818 {
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");

        int max=-1000000;
        int min= 1000000;

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(numbers[i]);

            if(a>max){
                max = a;
            }

            if(a<min){
                min = a;
            }
        }

        System.out.print(min + " "+max);
    }
}
