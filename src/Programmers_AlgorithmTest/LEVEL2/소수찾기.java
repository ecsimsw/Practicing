package Programmers_AlgorithmTest.LEVEL2;

import java.util.*;

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 */

public class 소수찾기 {
    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> setNumbers = new HashSet<>();

        Set<String> setComb = new HashSet<>();
        comb(new StringBuilder(numbers), setComb);

        for(String number : setComb){
            Set<String> setPerm = new HashSet<>();
            perm(new StringBuilder(number), new StringBuilder(),setPerm);

            for(String p : setPerm) setNumbers.add(Integer.parseInt(p));
        }

        for(int i : setNumbers){
            System.out.println(i);
            if(isPrime(i)) answer++;
        }

        return answer;
    }

    public void perm(StringBuilder left, StringBuilder picked, Set<String> list) {
        if (left.length() == 0) {
            list.add(picked.toString());
            return;
        }

        for (int i = 0; i < left.length(); i++) {
            char temp = ' ';

            temp = left.charAt(i);
            picked.append(left.charAt(i));
            left.delete(i, i + 1);

            perm(left, picked, list);

            left.insert(i,temp);
            picked.delete(picked.length() - 1, picked.length());
        }
    }
    public void comb(StringBuilder str, Set<String> list){
        if(str.length() == 0) return;
        else list.add(str.toString());

        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            str.delete(i,i+1);
            comb(str, list);
            str.insert(i, temp);
        }
    }

    public boolean isPrime(int n){
        if(n<2) return false;

        for(int i=2; i<n; i++){
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }
}
