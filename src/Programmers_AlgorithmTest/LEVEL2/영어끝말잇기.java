package Programmers_AlgorithmTest.LEVEL2;

import java.util.*;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> used = new LinkedList<String>();
        boolean end = false;

        for(int i=0; i<words.length; i++){
            if(words[i].length()>50 || words[i].length()<2) {  end = true; }

            if(!used.contains(words[i])) used.add(words[i]);
            else {end = true;}

            for(char c : words[i].toCharArray()){
                if(c<'a'  || c >'z') {
                    end= true;
                    break;
                }
            }

            if(i < words.length-1 && end== false){
                if(words[i].charAt(words[i].length()-1) != words[i+1].charAt(0)){
                    end = true;
                    i = i+1;
                }
            }

            if(end == true){
                answer[0] = (i)%n +1;
                answer[1] = (int)Math.ceil((i+1)/(float)n);
                return answer;
            }
        }

        return answer;
    }
}

