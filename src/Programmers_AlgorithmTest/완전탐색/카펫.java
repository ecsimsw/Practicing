package Programmers_AlgorithmTest.완전탐색;

import java.util.Scanner;

public class 카펫 {
    static public void main(String[] args){
        int brown = 10;
        int red = 2;

        System.out.println(solution(brown, red));
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        int n=0;
        int m=0;

        for(n=3; n<= (brown+4)/2; n++){
            m = (brown+4)/2 - n;
            if((n-2)*(m-2)==red){break;}
        }

        answer[0]=m;
        answer[1]=n;

        return answer;
    }
}
