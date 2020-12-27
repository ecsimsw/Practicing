package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b1655_우선순위큐_가운데를말해요 {
    private static PriorityQueue<Integer> smaller
            = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> bigger
            = new PriorityQueue<>();
    private static int middle = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        middle = Integer.parseInt(br.readLine());

        sb.append(middle + "\n");

        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > middle) {
                addBigger(n);
            } else if (n < middle) {
                addSmaller(n);
            } else if (n == middle) {
                if(smaller.size() < bigger.size()){
                    smaller.add(n);
                }else if(smaller.size() == bigger.size()){
                    bigger.add(n);
                }else if(smaller.size() > bigger.size()){
                    throw new Exception("잘못된 접근");
                }
            }

            sb.append(middle + "\n");
        }

        System.out.print(sb.toString());
    }

    private static void printList() {
        System.out.println(middle);
        System.out.println(smaller.toString());
        System.out.println(bigger.toString());
        System.out.println();
    }

    private static void addBigger(int n) {
        if (bigger.size() == smaller.size() + 1) {
            // middle 변경
            bigger.add(n);
            smaller.add(middle);
            middle = bigger.poll();
            return;
        }

        // middle 변경 없이 bigger만 추가
        bigger.add(n);
    }

    private static void addSmaller(int n) {
        if (smaller.size() == bigger.size()) {
            // middle 변경
            smaller.add(n);
            bigger.add(middle);
            middle = smaller.poll();
            return;
        }

        // middle 변경 없이 smaller만 추가
        smaller.add(n);
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
}

