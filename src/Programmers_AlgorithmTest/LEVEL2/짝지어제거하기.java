package Programmers_AlgorithmTest.LEVEL2;

import java.util.*;

public class 짝지어제거하기 {

    public static void main(String[] args){
        String s = "babbaa";

    }

    // 스택 풀이 , 정답

    public int solution(String s)
    {
        char[] chars = s.toCharArray();

        LinkedList<Character> stack = new LinkedList<>();

        for(char c : chars){
            if(!stack.isEmpty()){
                if(stack.peekLast() == c){
                    stack.pollLast();
                    continue;
                }
            }
            stack.offer(c);
        }

        for (char t : stack){
            System.out.print(t);
        }

        return stack.size() ==0? 1 : 0;
    }


    public static int sol1(String s){
        //시간 초과 틀린 풀이
        StringBuilder sb = new StringBuilder(s);

        while(true){
            int i =0;
            for(i =0; i <sb.length()-1; i++){
                if(sb.substring(i,i+1).equals(sb.substring(i+1,i+2))){
                    sb.delete(i,i+2);
                }
            }
            if(sb.length()<= 1 || i == sb.length()-1){
                break;
            }
        }
        return sb.length() ==0 ? 1 : 0;
    }

}
