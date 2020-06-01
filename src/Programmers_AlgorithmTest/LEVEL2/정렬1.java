package Programmers_AlgorithmTest.LEVEL2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 정렬1 {
    static void main(String[] args){
        solution1("asdfasdfZ");
    }

    static String solution1(String s) {
        String answer = "";

        char[] cArry = s.toCharArray();
        char[] rArry = new char[cArry.length];

        Arrays.sort(cArry);

        int i=cArry.length-1;
        for(char a : cArry){
            rArry[i--] = a;
        }

        answer = new String(rArry);
        return answer;
    }

    static public String solution2(String s) {
        String answer = "";

        char[] cArry = s.toCharArray();
        Arrays.sort(cArry);

        //StringBuilder sb = new StringBuilder(new String(cArry));
        StringBuilder sb = new StringBuilder(String.valueOf(cArry));

        sb.reverse();
        answer = sb.toString();
        return answer;
    }

    /*
  1. Arrays.sort(arry, Collections.reverseOrder()) / Arrays.sort(arry, new Comparator<Character>(){}) 모두 Character[] 이어야 쉽다.
  2. StringBuilder.reverse
  3. char[] -> String : String 생성자 or String.valueOf()
     */
}


/*
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 */