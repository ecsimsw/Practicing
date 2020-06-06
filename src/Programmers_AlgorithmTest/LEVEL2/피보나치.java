package Programmers_AlgorithmTest.LEVEL2;

public class 피보나치 {


=
        public int solution(int n) {
            int answer = 0;

            answer = func(n) %1234567;

            return answer;
        }

        public long func(long a) {
            long[] arr = new long[10000];

            if (a == 0) return 0;
            if (a == 1) return 1;
            if (a == 2) return 1;

            if (arr[(int) a] != 0) return arr[a] % 1234567;

            long r = func(a - 1) + func(a - 2);
            arr[r] = r;

            return r % 1234567;
        }


        // 재귀 없이
    class Solution {
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
}
