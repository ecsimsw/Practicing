package Programmers_AlgorithmTest.깊이너비우선탐색;

import java.util.Arrays;
import java.util.LinkedList;

public class 타겟넘버 {
    static public void main(String[] args){
        int[] numbers =new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }

    static int solution(int[] numbers, int target) {
        int answer = 0;

        Arrays.sort(numbers);

        LinkedList<Integer> sum = null;

        for(int i=0; i<numbers.length; i++){
            sum = makeSumSet(numbers[i],sum);
        }

        for(int i : sum){
            if(i==target) answer++;
        }

        return answer;
    }

    static LinkedList<Integer> makeSumSet(int a, LinkedList<Integer> setSum){
        LinkedList<Integer> resultSumset = new LinkedList<Integer>();

        if(setSum == null){
            resultSumset.add(a);
            resultSumset.add(-a);
        }
        else{
            for(int i : setSum){
                resultSumset.add(a+i);
                resultSumset.add(-a+i);
            }
        }

        return resultSumset;
    }
}
