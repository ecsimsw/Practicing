package Programmers_AlgorithmTest.LEVEL2;

public class 서울에서김서방찾기 {
    public java.lang.String solution(String[] seoul) {
        int position = 0;

        for(String s : seoul){
            if(s.equals("Kim"))
                break;
            position++;
        }
        return "김서방은 "+position+"에 있다";
    }
}
