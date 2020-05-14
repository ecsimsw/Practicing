package Programmers_AlgorithmTest.LEVEL2;

import java.util.*;

public class 문자열마음대로정하기 {

    static public void main(String[] args){
        String[] strings = {"bed", "don", "dojs"};
        String[] answer = solution(strings, 1);

        for(String s : answer){System.out.println(s);}
        System.out.print("sfd");
    }
    static public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.charAt(n) > o2.charAt(n)){return 1;}
            else if(o1.charAt(n) < o2.charAt(n)){return -1;}
            else{ return o1.compareTo(o2);}
         });
        return strings;
    }
}