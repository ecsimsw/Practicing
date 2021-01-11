package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class b11004_우선순위큐_k번째수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(nums[i]));
        }

        int index = 1;
        int ans = pq.poll();
        ;
        while (!pq.isEmpty()) {
            if (index == K) {
                break;
            }
            index++;
            ans = pq.poll();
        }

        System.out.print(ans);
    }
}


class b11004_비트마스킹_k번째수_메모리초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        boolean[] isUsed = new boolean[2000000001];

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            isUsed[1000000000 + Integer.parseInt(nums[i])] = true;
        }

        int index = 0;
        for (index = 0; index < isUsed.length; index++) {
            if (isUsed[index] == true) {
                K--;
            }

            if (K == 0) {
                break;
            }
        }

        System.out.print(index - 1000000000);
    }
}
