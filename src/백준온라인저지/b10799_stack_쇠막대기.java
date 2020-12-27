package 백준온라인저지;

import java.util.*;

class b10799_stack_쇠막대기 {
    public int solution(String arrangement) {

        String arr = arrangement;
        int answer = 0;

        LinkedList<Character> stack = new LinkedList<>();

        int point =0;

        char prev = ' ';

        for(int index =0; index< arr.length(); index++){
            if(prev =='(' && arr.charAt(index) == ')'){
                point--;
                answer += point;
                prev = ')';
                continue;
            }
            else if(prev ==')' && arr.charAt(index) == ')'){
                if(point >0){
                    answer++;
                    point--;
                    prev= ')';
                    continue;
                }
            }

            else if(arr.charAt(index) == '('){
                point++;
                prev= '(';
                continue;
            }

        }

        return answer;
    }
}