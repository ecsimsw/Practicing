package Programmers_AlgorithmTest.LEVEL2;

/*
  여러개의 최소 공배수 구하기

  다른 것 보다, 공배수 공약수 알고리즘 다시 리마인드 하는 느낌으로
 */

public class 다중최소공배수 {
    public int solution(int[] arr) {
        int answer = 1;

        for(int i : arr){
            answer = lcm(i,answer);
        }

        return answer;
    }
    int lcm(int a, int b){
        return (a*b) / gcd(a,b);
    }
    int gcd(int a, int b){
        while(a != b)
        {
            if(a>b) a-=b;
            else b-=a;
        }

        return a;
    }
}
