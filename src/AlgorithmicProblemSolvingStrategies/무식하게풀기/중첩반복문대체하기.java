package AlgorithmicProblemSolvingStrategies.무식하게풀기;

import java.util.*;

/*
    1. 재귀로 0~toPick 까지의 수 중 n개를 고르는 모든 경우의 수

    2. 재귀로 permutation 구현
 */

public class 중첩반복문대체하기 {

    static public void main(String[] args){
        pick(5, new LinkedList<>(), 2);
    }

    static void pick(int n, LinkedList<Integer>picked, int toPick){
        if(toPick == 0){
            for(int i : picked)
                System.out.print(i);
            System.out.println();
        }

        int smallest = picked.isEmpty() == true ? 0 : picked.getLast()+1;

        for(int i = smallest; i<=n; i++){
            picked.addLast(i);
            pick(n, picked, toPick-1);
            picked.pollLast();
        }
    }
}

class 조합 {
    static public void main(String[] args){
        LinkedList<String> results = new LinkedList<String>();
        pick(5, new LinkedList<>(), 2, results);

        for(String str : results) System.out.println(str);
    }

    static void pick(int n, LinkedList<Integer>picked, int toPick, LinkedList<String> r){
        if(toPick == 0){
            StringBuilder sb = new StringBuilder();
            for(int i : picked)
                sb.append(Integer.valueOf(i));
            r.add(sb.toString());
        }

        int smallest = picked.isEmpty() == true ? 0 : picked.getLast()+1;

        for(int i = smallest; i<=n; i++){
            picked.addLast(i);
            pick(n, picked, toPick-1, r);
            picked.pollLast();
        }
    }
}

