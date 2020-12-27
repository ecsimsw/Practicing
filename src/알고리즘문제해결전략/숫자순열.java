package 알고리즘문제해결전략;

import java.util.*;

/*
  숫자를 문자열로 받아 모든 순열을 list 담음
 */

public class 숫자순열 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        //perm(new StringBuilder("123"), new StringBuilder(), list);

        comb(new StringBuilder("123"), list);

        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void perm(StringBuilder left, StringBuilder picked, LinkedList<String> list) {
        if (left.length() == 0) {
            list.add(picked.toString());
            return;
        }

        for (int i = 0; i < left.length(); i++) {
            char temp = ' ';

            temp = left.charAt(i);
            picked.append(left.charAt(i));

            left.delete(i, i + 1);

            perm(left, picked, list);

            left.insert(i, temp);
            picked.delete(picked.length() - 1, picked.length());
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