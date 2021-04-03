package 프로그래머스.codingTest.kakaocommerce;

import java.util.HashMap;

public class c1 {
    public static void main(String[] args) {
        int[] gift = new int[]{5, 4, 5, 4, 5};
        int[] want = new int[]{1, 2, 3, 5, 4};
        int result = 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int g : gift){
            int now = map.getOrDefault(g, 0);
            map.put(g, now+1);
        }

        for(int w : want){
            int count = map.getOrDefault(w, 0);
            if(count != 0){
                map.put(w, count-1);
            }
        }

        int answer = 0;
        for(int i : map.values()){
            if(i != 0){
                answer += i;
            }
        }

        System.out.println(answer);
    }
}
