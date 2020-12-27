package 프로그래머스.LEVEL2;

import java.util.*;

public class 숫자야구 {
    public int solution(int[][] baseball) {

        int answer = 0;

        LinkedList<Integer> candidates = new LinkedList<>();

        HashSet<Integer> set = new HashSet<>();
        toPick(0, new StringBuilder(), set);

        LinkedList<Integer> permed = new LinkedList<>();
        for(int integer : set){
            permed.clear();
            perm(new StringBuilder(), new StringBuilder(""+integer), permed);
            for(int number : permed){
                candidates.add(number);
            }
        }
        for(int[] ask : baseball){
            int i=0;
            while(i<candidates.size()){
                int[] result = score(candidates.get(i),ask[0]);
                if(result[0] != ask[1] || result[1] != ask[2]){
                    candidates.remove(i);
                }
                else{i++;}
            }
        }

        answer = candidates.size();

        return answer;
    }

    public void perm(StringBuilder done, StringBuilder left, LinkedList<Integer> list){
        if(left.length() == 0){
            list.add(Integer.parseInt(done.toString()));
            return;
        }

        for(int i=0; i<left.length(); i++){
            char temp = left.charAt(i);
            perm(done.append(temp), left.delete(i,i+1), list);
            left.insert(i,temp);
            done.delete(done.length()-1, done.length());
        }
    }

    public void toPick(int index, StringBuilder picked, HashSet<Integer> set){
        if(index == 3){
            set.add(Integer.parseInt(picked.toString()));
            return;
        }

        int smallest = (index == 0 ? 1 : Character.getNumericValue(picked.charAt(index-1))+1);

        for(int i= smallest; i<= 9-(2-index); i++){
            toPick(index+1, picked.append(i),set);
            picked.delete(picked.length()-1, picked.length());
        }
    }

    public int[] score(int intQ, int intA){
        int[] s = new int[2];

        String q = String.valueOf(intQ);
        String a = String.valueOf(intA);

        int strike =0;
        int ball =0;

        for(int k=0; k<3; k++){
            if(q.charAt(k) == a.charAt(k)){
                strike++;
            }
        }

        for(int k=0; k<3; k++){
            for(int j=0; j<3; j++){
                if(q.charAt(k) == a.charAt(j)){
                    ball++;
                    break;
                }
            }
        }

        s[0] = strike;
        s[1] = ball-strike;
        return s;
    }
}