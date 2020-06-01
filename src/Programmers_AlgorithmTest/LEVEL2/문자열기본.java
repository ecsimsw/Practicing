package Programmers_AlgorithmTest.LEVEL2;

public class 문자열기본 {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }

        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            answer = false;
        }

        return answer;
    }
}

/*
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 */