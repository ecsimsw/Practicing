package Programmers_AlgorithmTest.탐욕법;

import java.util.*;

public class 큰수만들기 {
    static public void main(String[] args){
       String number = "6669616";
       int k=4;

        System.out.println(solution(number,k));
    }
   static public String solution(String number, int k) {
        String answer = "";

        int length = number.length() - k;

        if( k>=number.length()) return answer;

        String left = number.substring(0,k);

        LinkedList<Character> definedNumber = new LinkedList<>();

        char[] defined = number.substring(k, number.length()).toCharArray();

        int index = k-1;

        while(index>=0){
            char addChar = left.charAt(index--);
            char preChar = addChar;

            for(int i=0; i<defined.length; i++){
                if(  preChar>=defined[i]){
                    char temp = defined[i];
                    defined[i] = preChar;
                    preChar = temp;
                }else break;
            }
        }
        StringBuilder sb = new StringBuilder();

       for(char c : defined)
           sb.append(c);

       answer = sb.toString();
        return answer;
    }
}

/*
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 */