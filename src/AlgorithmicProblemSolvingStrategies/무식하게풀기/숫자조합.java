package AlgorithmicProblemSolvingStrategies.무식하게풀기;

import java.util.Collections;
import java.util.LinkedList;

import java.util.*;

public class 숫자조합 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        comb(new StringBuilder("123"), list);

        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }

    }
    public static void comb(StringBuilder str, LinkedList<String> list){
        if(str.length() == 0) return;
        else list.add(str.toString());

        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            str.delete(i,i+1);
            comb(str, list);
            str.insert(i, temp);
        }
    }
}