package 프로그래머스.LEVEL2;

public class 가운데숫자가져오기 {

    public static void main(String[] args){
        String s = "hello";
        sol(s);
    }
    public static String sol(String s){
        String answer = "";

        answer = s.substring((int)Math.ceil(s.length()/2.0-1), (int)Math.floor(s.length()/2.0+1));

        //주의1 : Math.ceil / Math.floor는 double 반환
        //주의2 : subString이 아니라, substring

        return answer;
    }
}

/*
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 */