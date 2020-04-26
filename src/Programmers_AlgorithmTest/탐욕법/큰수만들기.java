package Programmers_AlgorithmTest.탐욕법;

import java.util.LinkedList;
import java.util.Queue;

public class 큰수만들기 {
    static public void main(String[] args){
        String number = "1112333884554";
        int k = 3;

        System.out.println("sa : "+solution(number,k));
    }
    static public String solution(String number, int k) {
        String answer = "";

        int length = number.length()-(number.length() - k);

        String left = number.substring(0,length);

        System.out.println("left : "+left);

        LinkedList<Character> definedNumber = new LinkedList<>();

        for(char c : number.substring(length, number.length()).toCharArray()) definedNumber.add(c);

        int index = number.length() - k -1;

        while(index>=0){
            for(char c : definedNumber)
                System.out.print(c);
            System.out.println("\nadd  "+ left.charAt(index));

            definedNumber.addFirst(left.charAt(index));

            int i=0;
            for(i=0; i<definedNumber.size()-1; i++){
                if(definedNumber.get(i) < definedNumber.get(i+1)) {
                    definedNumber.remove(i);
                    break;
                }
            }

            if(definedNumber.size() > length) definedNumber.remove(definedNumber.size()-1);

            for(char c : definedNumber)
                System.out.print(c);
            System.out.println();
            System.out.println();

            index--;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : definedNumber)
            sb.append(c);

        answer = sb.toString();
        return answer;
    }
}
