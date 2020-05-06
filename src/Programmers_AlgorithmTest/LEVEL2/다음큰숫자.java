package Programmers_AlgorithmTest.LEVEL2;

public class 다음큰숫자 {
    public static void main(String[] args){
        int n = 78;
        System.out.println(Integer.bitCount(78));  // Integer.bitCount()
        System.out.println(solution(n));              // Integer.toBinaryString()
                                                      // Integer.parse(number, 2)
    }

    static public int solution(int n) {
        int answer = 0;

        String byteString = Integer.toBinaryString(n);

        int numberOfOne =0;
        for(int i =0; i<byteString.length(); i++){
            if(byteString.charAt(i) =='1'){ numberOfOne++;}
        }

        n++;
        while(true){
            byteString = Integer.toBinaryString(n);

            int temp_numberOfOne=0;
            for(int i =0; i<byteString.length(); i++){
                if(byteString.charAt(i) =='1'){ temp_numberOfOne++;}
            }

            if(temp_numberOfOne == numberOfOne){break;}
            n++;
        }
        answer = n;
        return answer;
    }
}
