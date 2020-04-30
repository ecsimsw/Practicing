package Programmers_AlgorithmTest.이진탐색;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args){
        int[] budgets = new int[]{120, 140, 110, 150};
        int M = 485;

        System.out.println(solution(budgets, M));
    }


    public static int solution(int[] budgets, int M) {
        int answer = 0;

        int numberOfCities = budgets.length;

        Arrays.sort(budgets);

        int sum =0;

        for(int i : budgets){
            sum += i;
        }

        if(sum > M){
            for(int index = 0; index<numberOfCities; index++){

            }
        }
        else return budgets[numberOfCities-1];



        return answer;
    }
}
