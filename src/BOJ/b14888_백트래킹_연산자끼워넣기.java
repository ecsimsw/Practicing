package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class b14888_백트래킹_연산자끼워넣기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        String[] numberStr = br.readLine().split(" ");

        numbers = new int[n];
        for(int i = 0; i<n; i++){
            numbers[i] = Integer.parseInt(numberStr[i]);
        }

        String[] operators = br.readLine().split(" ");
        operator = new int[4];
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(operators[i]);
        }

        func(1,numbers[0]);

        System.out.println(max);
        System.out.print(min);
    }

    static int[] operator;
    static int[] numbers;
    static int n;

    static int max =-1000000000;
    static int min = 1000000000;

    static void func(int index, int result){
        if(index == n){
            if(max < result){max = result;}
            if(min > result){min = result;}
            return;
        }

        if(operator[0]>0){
            operator[0]--;
            func(index+1, result+numbers[index]);
            operator[0]++;
        }
        if(operator[1]>0){
            operator[1]--;
            func(index+1, result-numbers[index]);
            operator[1]++;
        }
        if(operator[2]>0){
            operator[2]--;
            func(index+1, result*numbers[index]);
            operator[2]++;
        }
        if(operator[3]>0){
            operator[3]--;
            func(index+1, result/numbers[index]);
            operator[3]++;
        }
    }
}
