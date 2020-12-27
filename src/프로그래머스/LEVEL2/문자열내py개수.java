package 프로그래머스.LEVEL2;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();

        int numP =0;
        int numY =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'y') numY++;
            else if(s.charAt(i) == 'p') numP++;
        }

        return numY == numP;
    }
}
