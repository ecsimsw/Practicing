package 프로그래머스.Hash;

import java.util.Arrays;

public class 전화번호목록 {
    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524431", "4234234234"};
    }

    static boolean Array(String[] phoneBook){
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i].length() > phoneBook[i + 1].length()) continue;
            else {
                phoneBook[i].equals(phoneBook[i + 1].substring(0, phoneBook[i].length()));
                return false;
            }
        }
        return true;
    }
}

/*
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
