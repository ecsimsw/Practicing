package 프로그래머스.Sort;

import java.util.*;

public class 가장큰수 {
    public static void main(String[] args) {
        int[] numbers = new int[]{0,0,0,0};
        System.out.println(solution(numbers));
    }

    static String solution(int[] numbers) {
        String answer = "";

        String[] numbers_str = new String[numbers.length];

        boolean isAllZero= true;

        for(int i=0; i<numbers.length; i++){
            numbers_str[i] = String.valueOf(numbers[i]);
            if(!numbers_str[i].equals("0")) isAllZero = false;
        }

        if(isAllZero)
            return "0";

        Arrays.sort(numbers_str,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });

        //Arrays.sort(number_str,(o1, o2) -> -(o1+o2).compareTo(o2+o1)))

        StringBuilder sb = new StringBuilder();
        for(String n : numbers_str){
            sb.append(n);
        }

        answer= sb.toString();

        return answer;
    }
}


/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 */