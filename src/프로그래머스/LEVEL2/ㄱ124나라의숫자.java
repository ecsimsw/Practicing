package 프로그래머스.LEVEL2;

public class ㄱ124나라의숫자 {
    public static void main(String[] args) {
       // int n = 4567456;
        int n = 546;

        System.out.println(solution2(n));
    }

    static public String solution2(int n){
        String answer ="";
        int k = 0;

        while (n>0){

            System.out.println("n : "+n);

            k = n%3;
            n = n/3;

            if(k ==0){
                n--;
                k = 4;
            }

            System.out.println("n : "+n);

            answer = k+answer;
        }

        return answer;
    }

    static public String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        while(true){
            sb.insert(0, n % 3);
            // 인덱스로 넣을 때는 insert, 그냥 붙일때는 append
            n = n/3;

            if(n<=2){ sb.insert(0, n % 3); break; }
        }
        System.out.println(sb);

        int indexNow =sb.length()-1;

        while(indexNow > 0){
           if(Character.getNumericValue(sb.charAt(indexNow)) <= 0){
                sb.setCharAt(indexNow, (char)(Character.getNumericValue(sb.charAt(indexNow))+3+'0'));
                sb.setCharAt(indexNow-1, (char)(Character.getNumericValue(sb.charAt(indexNow-1))-1+'0'));
                //sb.setCharAt(indexNow-1, (char)(Character.getNumericValue(sb.charAt(indexNow-1))-1)); X
           }
           indexNow--;
        }

        indexNow =0;

        while(indexNow !=sb.length()){
            if(sb.charAt(indexNow) == '3'){ sb.setCharAt(indexNow,'4'); }indexNow++;
        }

        if(sb.charAt(0) == '0'){
            sb.delete(0,1);
            // sb.delete(0,0) 아님
        }

        answer =sb.toString();
        return answer;
    }
}

/*
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 */