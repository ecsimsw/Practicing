package 프로그래머스.탐욕법;

import java.util.Arrays;

public class 조이스틱 {
    public static void main(String[] args){
        String name = "JAN";
        System.out.print(solution(name));
    }


    //현재 인덱스보다 큰 첫번째 인덱스가, 오른쪽으로 처리하는게 빠른지, 왼쪽으로 처리하는게 빠른지만 고민하면돼
    static public int solution(String name){
        int answer =0;

        boolean[] isSetted = new boolean[name.length()];
        char[] chars = name.toCharArray();
        Arrays.fill(isSetted, false);

        for(int i=0; i<chars.length; i++){
            if(chars[i]=='A') isSetted[i] = true;
        }

        int now =0;
        int next = now;

        while(true){
            int i=0;
            for(i=0; i <isSetted.length; i++){
                int right = (now+i)%isSetted.length;
                int left = now -i > -1 ? now-i : isSetted.length+(now-i);

                if(isSetted[right] == false) {next = right; answer+=i; break;}
                if(isSetted[left] == false) {next = left; answer+=i; break;}
            }

            if(i==isSetted.length) break;

            isSetted[next] = true;
            int nextChar = chars[next];

            now = next;

            System.out.println("now : "+now);
            answer += Math.min(nextChar - 'A', 26-(nextChar - 'A'));
            System.out.println("answer : "+answer);

        }
        return answer;
    }
}
