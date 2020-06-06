package Programmers_AlgorithmTest.LEVEL2;

/*
    문자열 메소드 정리

  1. char를 대소문자로 바꿀땐, Character.toUpperCase()

  2. substring과 string의 toUpperCase()는 그 문자열을 바꾸는게 아니라, 결과를 리턴하는 메소드이다.

  3. str.contains() / str.charAt() / str.indexOf() / str.toCharArray() / str.substring() / str.toUpperCase() /
 */

public class JadenCase문자열만들기 {
    public String solution1(String s) {
        String answer = "";

        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean afterSpace = true;

        for(char c : charArray){
            if(afterSpace)
                sb.append(Character.toUpperCase(c));
            else{
                sb.append(Character.toLowerCase(c));
            }

            if(c == ' ') afterSpace = true;
            else afterSpace = false;
        }

        answer = sb.toString();

        return answer;
    }
}
