package 프로그래머스.LEVEL2;

// 재귀 없이 피보나치
public class 피보나치 {
    public int solution(int n) {
        if(n==0 || n ==1) return n;

        int i= 2;

        int pre = 1;
        int ppre = 0;
        int now = 0;

        while(i<=n){
            now = pre + ppre;
            ppre = pre;
            pre = now;
            i++;
        }

        int answer = now;

        return answer;
    }
}
