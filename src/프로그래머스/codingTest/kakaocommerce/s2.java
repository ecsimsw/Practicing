package 프로그래머스.codingTest.kakaocommerce;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s2 {
    public static void main(String[] args) {

        needs = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        r= 2;

        n = needs[0].length;
        combination(new LinkedList<>(), 0);

        System.out.println(max);
    }

    static int[][] needs;
    static int n;
    static int r;
    static int max =0;

    public static List<Integer> combination(LinkedList<Integer> choosen, int last){
        if(choosen.size() == r){

            int ableToMake =0;
            for(int i =0; i< needs.length; i++){
                if(choosen.containsAll(findRequareNumber(i))){
                    ableToMake++;
                }
            }

            max = Math.max(max, ableToMake);
            return choosen;
        }

        for(int i =last; i <n; i++){
            choosen.addLast(i);
            combination(choosen, i+1);
            choosen.pollLast();
        }

        return choosen;
    }

    public static LinkedList<Integer> findRequareNumber(int i ){
        LinkedList<Integer> requares = new LinkedList<>();

        int j =0;
        for(int r : needs[i]){
            if(r ==1){
                requares.add(j);
            }
            j++;
        }

        return requares;
    }

}
