package 프로그래머스.Hash;

import java.util.HashMap;

public class 위장 {
    public static void main(String[] args){
         Hash();
    }

    public static void Hash(){
        String[][] clothes = {
                {"hat","headgear"}
                ,{"sunglasses","eyewear"}
                ,{"turbun","headgear"}
        };

        HashMap<String, Integer> hm = new HashMap();

        for(String[] entry : clothes){ hm.put(entry[1], hm.getOrDefault(entry[1],0)+1); }

        int answer = 1;
        for(Integer count : hm.values()){ answer *= (count+1); }

        answer--;
    }
}
/*
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경,
 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나
  동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 */