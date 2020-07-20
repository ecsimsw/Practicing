package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1541_그리디_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String[] splited = line.split("-");

        int sum =0;

        for(String s : splited[0].split("\\+")) {
            sum += Integer.parseInt(s);
        }

        for(int i =1; i<splited.length; i++){
            String[] number = splited[i].split("\\+");

            int sumOfPlus =0;
            for(String s : number){
                sumOfPlus += Integer.parseInt(s);
            }

            sum-=sumOfPlus;
        }

        System.out.print(sum);
    }
}
