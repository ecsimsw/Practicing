package Programmers_AlgorithmTest.codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UATC_1 {

}

class UATC_1_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] money = new int[]{50000,10000,5000,1000,500,100,50,10,1};
        int[] used = new int[money.length];

        int input = Integer.parseInt(br.readLine());

        for(int m=0; m<money.length; m++){
            if(input>=money[m]){
                used[m] = input/money[m];
                input%=money[m];
            }
        }

        for(int m=0; m<money.length; m++){
            System.out.print(used[m] + " ");
        }

    }
}

class UATC_1_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[][]{
                {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
                {'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C','B','A'}
        };

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        char aft =' ';
        for(char c : input.toCharArray()){
            aft = c;

            int toInt = (int)c;
            if(toInt>=97 && toInt<=122){ // 소문자
                aft = (char)(122-toInt+97);
            }
            else if(toInt>=65 && toInt<=90){ // 소문자
                aft = (char)(90-toInt+65);
            }
            sb.append(aft+"");
        }

        System.out.println(sb);
    }
}

class UATC_1_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        pobi = new int[2];
        crong = new int[2];

        pobi[0] = Integer.parseInt(str[0]);
        pobi[1] = Integer.parseInt(str[1]);
        crong[0] = Integer.parseInt(str[2]);
        crong[1] = Integer.parseInt(str[3]);

        if(hasErr(pobi) || hasErr(crong)){
            System.out.println(-1);
            return;
        }

        int score_p = getScore(pobi);
        int score_c = getScore(crong);

        if(score_p>score_c){
            System.out.println(1);
        }
        else if(score_p < score_c){
            System.out.println(2);
        }
        else{
            System.out.println(0);
        }
    }

    static int[] pobi;
    static int[] crong;

    static boolean hasErr(int[] arr){
        // 짝 홀 판단
        if(arr[0]/2 !=0 && arr[1] == arr[0]+1){

        }else{ return true; }

        // 유효 페이지 범위 판단
        if(arr[0]<1 || arr[0]>400){
            return true;
        }

        return false;
    }

    static int getScore(int[] arr){
        int left = arr[0];
        int right = arr[1];

        int max = Math.max(Math.max(allSum(left),allSum(right)), Math.max(allMul(left), allMul(right)));
        return max;
    }

    static int allSum(int i){
        int sum=0;
        while(i>=1){
            sum+= i%10;
            i = i/10;
        }
        return sum;
    }

    static int allMul(int i){
        int res =1;
        while(i>=1){
            res *= i%10;
            i = i/10;
        }
        return res;
    }
}

class UATC_1_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count=0;

        for(int i=1; i<n; i++){
            if(is369(i)) count++;
        }

        System.out.println(count);
    }

    static boolean is369(int n){
        while(n>=1){
            if(n%10 == 3 || n%10 ==6 || n%10==9){
                return true;
            }
            n = n/10;
        }

        return false;
    }
}

class UATC_1_6 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count=0;

        for(int i=1; i<n; i++){
            if(is369(i)) count++;
        }

        System.out.println(count);
    }

    static boolean is369(int n){
        while(n>=1){
            if(n%10 == 3 || n%10 ==6 || n%10==9){
                return true;
            }
            n = n/10;
        }

        return false;
    }
}
