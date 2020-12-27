package 프로그래머스.완전탐색;

import java.util.ArrayList;

public class 소수찾기 {
    static public void main(String[] args){
        solution("176");
    }

    static int solution(String numbers) {
        int answer = 0;

        String splited[] = numbers.split("");

        for(int i=1; i< Math.pow(2,numbers.length()); i++){
            String usingBit = Integer.toBinaryString(i);


            // 사용될 종이 조각 비트로 표현
            int leftBits = numbers.length()-usingBit.length();
            for(int j=0; j<leftBits; j++){
                usingBit = "0"+usingBit;
            }

            System.out.println(usingBit);

            // 사용될 숫자 담기

            ArrayList<String> usingNumber = new ArrayList<String>();

            for(int digits=0; digits<usingBit.length(); digits++){
                if(usingBit.charAt(digits)=='1'){usingNumber.add(splited[digits]);}
            }

            for(String s : usingNumber)
                System.out.print(s);

            System.out.println();

            ArrayList<String> madeNumbers = new ArrayList<>();

            // 사용할 숫자를 조합해 만들어진 숫자 담기

            for(int tempI=0; tempI<usingNumber.size(); tempI++){
                for(int tempJ=0; tempJ<usingNumber.size(); tempJ++){

                }
            }

        }

        //System.out.println(number.peek());

        return answer;
    }
    static boolean isPrime(int i){
        if(i ==0 || i==1) return false;

        for(int index=2; index < i; index++){
            if(i%index==0) return false;
        }
        return true;
    }
}

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 */