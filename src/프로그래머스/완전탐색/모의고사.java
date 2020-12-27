package 프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args){
        int[] answers = new int[]{1,2,3,4,5};

        System.out.println(solution(answers).toString());
    }

    static int[] solution(int[] answers) {
        int[] A_answer = new int[]{1, 2, 3, 4, 5};
        int[] B_answer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] C_answer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int a_correct=0;
        int b_correct=0;
        int c_correct=0;

        for(int i=0; i < answers.length; i++) {
            if (answers[i] == A_answer[i % A_answer.length]) a_correct++;
            if (answers[i] == B_answer[i % B_answer.length]) b_correct++;
            if (answers[i] == C_answer[i % C_answer.length]) c_correct++;
        }

        int[] corrects = new int[]{a_correct, b_correct, c_correct};
        int[] temp = corrects.clone();
        Arrays.sort(temp);
        int max = temp[2];

        ArrayList<Integer> answerL = new ArrayList();
        for(int index =0; index<corrects.length; index++){
            if(corrects[index] == max){
                answerL.add(index+1);
            }
        }


        int[] answer = new int[answerL.size()];

        for(int i=0; i<answerL.size(); i++){
            answer[i] = answerL.get(i);
        }

        return answer;
    }
}

/*
수포자는 수학을 포기한 사람의 준말입니다.
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */