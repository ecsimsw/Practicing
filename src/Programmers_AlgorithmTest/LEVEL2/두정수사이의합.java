package Programmers_AlgorithmTest.LEVEL2;


public class 두정수사이의합 {
    public static void main(String[] args){
System.out.println(Math.pow(3,3)); //27.0
System.out.println(Math.abs(-1)); //1

System.out.println(Math.max(1,3)); //3
System.out.println(Math.min(1,3)); //1

System.out.println(Math.ceil(2.221)); //3.0
System.out.println(Math.floor(2.221)); //2.0

System.out.println(Math.round(2.221)); //2

System.out.println(Math.sqrt(4)); //2.0
    }

    public long solution(int a, int b) {
        long answer = 0;
        int max = (a > b)? a : b;
        int min = (a > b)? b : a;

        for(int i = min; i <= max; i++){
            answer += i;
        }

        return answer;
    }
}
