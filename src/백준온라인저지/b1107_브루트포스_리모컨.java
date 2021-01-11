package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class b1107_브루트포스_리모컨_위아래탐색 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(brokenNums, true);

        int n = Integer.parseInt(br.readLine());

        int numberOfBroken = Integer.parseInt(br.readLine());
        if (numberOfBroken == 0) {
            br.readLine();
        } else {
            String[] brokenNumber = br.readLine().split(" ");
            for (int i = 0; i < numberOfBroken; i++) {
                brokenNums[Integer.parseInt(brokenNumber[i])] = false;
            }
        }
        minMove = arrowButton(n, 100);

        for (int i = n; i > -1; i--) {
            int move = 0;
            int moveByNumPad = numberButton(i);

            if (moveByNumPad == -1) {
                continue;
            }

            move += moveByNumPad;
            move += arrowButton(n, i);

            minMove = Math.min(minMove, move);
            break;
        }

        for (int i = n; i <= 1000000; i++) {
            int move = 0;
            int moveByNumPad = numberButton(i);

            if (moveByNumPad == -1) {
                continue;
            }

            move += moveByNumPad;
            move += arrowButton(n, i);

            minMove = Math.min(minMove, move);
            break;
        }

        System.out.print(minMove);
    }

    private static int minMove = 0;
    private static boolean[] brokenNums = new boolean[10];

    private static int arrowButton(int n, int now) {
        return Math.abs(n - now);
    }

    private static int numberButton(int i) {
        if (i == 100) {
            return 0;
        }

        if (i == 0) {
            if (brokenNums[0] == true) {
                return 1;
            }
            return -1;
        }

        int moveCnt = 0;

        while (i > 0) {
            int digit = i % 10;
            i /= 10;

            if (brokenNums[digit] == false) {
                return -1;
            }
            moveCnt++;
        }

        return moveCnt;
    }
}


class b1107_브루트포스_리모컨_전부비교 {
    private static int minMove = 0;
    private static boolean[] brokenNums = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(brokenNums, true);

        int n = Integer.parseInt(br.readLine());

        int numberOfBroken = Integer.parseInt(br.readLine());
        if (numberOfBroken == 0) {
            br.readLine();
        } else {
            String[] brokenNumber = br.readLine().split(" ");
            for (int i = 0; i < numberOfBroken; i++) {
                brokenNums[Integer.parseInt(brokenNumber[i])] = false;
            }
        }
        minMove = arrowPad(n, 100);

        for (int i = 0; i <= 1000000; i++) {
            int move = 0;
            int moveByNumPad = numPad(i);

            if (moveByNumPad == -1) {
                continue;
            }

            move += moveByNumPad;
            move += arrowPad(n, i);

            minMove = Math.min(minMove, move);
        }

        System.out.print(minMove);
    }

    private static int arrowPad(int n, int now) {
        return Math.abs(n - now);
    }

    private static int numPad(int i) {
        if (i == 100) {
            return 0;
        }

        if (i == 0) {
            if (brokenNums[0] == true) {
                return 1;
            }
            return -1;
        }

        int moveCnt = 0;

        while (i > 0) {
            int digit = i % 10;
            i /= 10;

            if (brokenNums[digit] == false) {
                return -1;
            }

            moveCnt++;
        }

        return moveCnt;
    }
}
