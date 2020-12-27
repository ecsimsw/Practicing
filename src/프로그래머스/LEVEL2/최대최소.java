package 프로그래머스.LEVEL2;

import java.util.*;

public class 최대최소 {

    public static void main(String[] args){
        String str = "-7 2-1 3-5";

        System.out.print(solution(str));
    }

    public static String solution(String s) {
        String answer = "";
        String[] splited = s.split(" ");

        List<Integer> integers = new LinkedList<Integer>();

        for(String m : splited){
            String[] minus = m.split("-");
            if(!minus[0].equals("")) integers.add(Integer.parseInt(minus[0]));

            for(int i=1; i<minus.length; i++) integers.add(Integer.parseInt(minus[i])*-1);
        }

        Collections.sort(integers);

        int min = integers.get(0);
        int max = integers.get(integers.size()-1);

        return min+" / "+max;
    }
}
