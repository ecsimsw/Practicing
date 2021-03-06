package 프로그래머스.Stack_Queue;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args){
        int price[] = new int[]{1, 2, 3, 2, 3};

        solution(price);
    }

    static public int[] solution(int[] prices) {
        int[] answer;

        Stack<Integer> answers = new Stack<>();

        for(int index= 0; index<prices.length; index++){
            int now = index;
            int next = index+1;
            int remain =0;
            while(next < prices.length){
                remain++;
                if(prices[now]<=prices[next]) { next++; }
                else { answers.add(remain);break; }

                if(next == prices.length){ answers.add(remain);break; }
            }
        }
        answers.add(0);

        answer = new int[answers.size()];
        int index=0;

        for(int i : answers){
            answer[index++] = i;
        }

        return answer;
    }
}

/*
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.
 */