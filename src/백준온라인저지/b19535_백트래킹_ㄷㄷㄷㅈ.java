package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class b19535_백트래킹_ㄷㄷㄷㅈ {
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Long[] nums = new Long[6];
//        String[] numbers = br.readLine().split(" ");
//        for(int i=0; i<6; i++){ nums[i] = Long.parseLong(numbers[i]); }

        line = new int[300001];

//        board[1][2] = true;
        line[1]++;
        line[2]++;
//        board[2][3] = true;
        line[2]++;
        line[3]++;
//        board[3][4] = true;
        line[3]++;
        line[4]++;
//        board[4][5] = true;
        line[4]++;
        line[5]++;
//        board[4][6] = true;
        line[4]++;
        line[6]++;

        int lineCount = 4;

        int zCount = findZcount();

        System.out.println(lineCount-zCount +" "+zCount);


        if(lineCount-zCount == 3*zCount){
            System.out.print("DUDUDUNGA");
        }
        else if(lineCount-zCount < 3*zCount){
            System.out.print("G");
        }
        else{
            System.out.print("D");
        }
    }

    static int[] line;

    static int findZcount(){
        int sum=0;
        for(int i =1; i<300001; i++){
            if(line[i] >= 3) sum+=combination(line[i],3);
        }
        return sum;
    }

    static int combination(int n, int m){
        int result = 1;
        for(int i=1; i<=m; i++){
            result *= (n-i+1);
            result /= i;
        }
        return result;
    }
}
