package AlgorithmicProblemSolvingStrategies.무식하게풀기;

import java.util.*;

public class 숫자조합 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        perm(new StringBuilder("123"),new StringBuilder(), list);

        for(String s : list) {
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

            left.append(temp);
            picked.delete(picked.length() - 1, picked.length());
        }
    }
}