package Programmers_AlgorithmTest.LEVEL2;

public class 올바른괄호 {
    public static void main(String[] args){

    }
static boolean solution(String s) {
    boolean answer = true;

    int stack =0;
    for(int i =0; i<s.length(); i++){
        if(s.charAt(i)=='('){ stack ++; }
        else {
            if(stack>0){ stack--; }
            else{ return false; }
        }
    }
    answer = (stack == 0);

    return answer;
}
}

