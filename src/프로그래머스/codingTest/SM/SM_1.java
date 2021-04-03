package 프로그래머스.codingTest.SM;

import java.util.Scanner;

/*
8
1 3 10 9 6 2 3 2

8
10 3 9 2 6 2 3 2
 */

class SM_1 {
    static int[] arr;
    static boolean[] isUsed;
    static int max;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] strings = sc.nextLine().split(" ");
        arr = new int[n];
        isUsed = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        func(n / 2, 0);
        System.out.println(max);
    }

    static void func(int n, int sum) {
        if (n < 1) {
            max = Integer.max(max, sum);
            return;
        }

        for (int index = 0; index < arr.length; index += n) {
            if (isUsed[index] == false) {
                int max = findMax(index, n);
                checkUsed(index, n);
                func(n / 2, sum + max);
                uncheckUsed(index, n);
            }
        }
    }

    static int findMax(int index, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Integer.max(arr[i + index], max);
        }
        return max;
    }

    static void checkUsed(int index, int n) {
        for (int i = 0; i < n; i++) {
            isUsed[index + i] = true;
        }
    }

    static void uncheckUsed(int index, int n) {
        for (int i = 0; i < n; i++) {
            isUsed[index + i] = false;
        }
    }
}
