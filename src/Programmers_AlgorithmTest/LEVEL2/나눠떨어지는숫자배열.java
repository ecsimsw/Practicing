package Programmers_AlgorithmTest.LEVEL2;

import java.util.Collections;
import java.util.LinkedList;

public class 나눠떨어지는숫자배열 {

    public static void main(String[] args){}
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        LinkedList<Integer> answer_list = new LinkedList<>();

        for(int i : arr){
            if(i%divisor == 0){answer_list.add(i);}
        }

        if(answer_list.size() == 0){answer = new int[]{-1};}
        else{
            Collections.sort(answer_list);
            answer = new int[answer_list.size()];
            int i=0;
            for(int j : answer_list){answer[i] = j; i++;}
        }

        return answer;
    }
}
