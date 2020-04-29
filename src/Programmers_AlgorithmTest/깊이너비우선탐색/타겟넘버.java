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

        answer = dfs(0,0,numbers,target);
      
        return answer;
    }

    static int dfs(int preSum, int index, int[] numbers, int target){
        if(index == numbers.length)
        {
            if(preSum == target) return 1;
            else{ return 0; }
        }

        return dfs(preSum + numbers[index], index+1, numbers, target)
          + dfs(preSum - numbers[index], index+1, numbers, target);
    }


    public int solution2(int[] numbers, int target) {
        int answer = 0;

        LinkedList<Integer> sum = null;

        for(int i=0; i<numbers.length; i++){
            sum = addition(numbers[i],sum);
        }

        for(int i : sum) { if(i==target) answer++;}

        return answer;
    }

    LinkedList<Integer> addition(int a, LinkedList<Integer> preSum){
        LinkedList<Integer> result = new LinkedList<Integer>();

        if(preSum == null){
            result.add(a);
            result.add(-a);
        }
        else{
            for(int i : preSum){
                result.add(a+i);
                result.add(-a+i);
            }
        }

        return result;
    }
}
