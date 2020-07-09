package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class b11729_재귀_하노이탑2 {
    static int n, cnt = 0;
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int n, int from, int by, int to) {
        cnt++;
        if (n == 1) { // 원판이 1개일 때
            sb.append(from + " " + to + "\n");
            return;
        } else { // 원판이 1개가 아닐 때
            hanoi(n - 1, from, to, by); // n-1을 한 후, 1->3->2로 원판을 전달
            sb.append(from + " " + to + "\n");
            hanoi(n - 1, by, from, to); // n-1을 한 후, 2->1->3으로 원판을 전달
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Long now = System.currentTimeMillis();
        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
}

// Print를 여러번 하는 방식

class 재귀_하노이탑1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long now = System.currentTimeMillis();

        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2,N)-1);
        move(1,3,N);

        System.out.println(System.currentTimeMillis()-now);
    }

    static void move(int from, int to, int count){
        if(count ==1) {
            System.out.println(from + " " + to);
            return;
        }

        int next = 6- from- to;

        move(from, next, count-1);

        System.out.println(from+" "+to);
        move(next, to, count-1);
    }
}

// StringBuilder로 합쳐 한번에 프린트하는 방식

class 재귀_하노이탑2 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long now = System.currentTimeMillis();
        System.out.println((int)Math.pow(2,N)-1);
        move(1,3,N);
        System.out.println(sb);
        System.out.println(System.currentTimeMillis()-now);
    }

    static void move(int from, int to, int count){
        if(count ==1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        int next = 6- from- to;
        move(from, next, count-1);
        sb.append(from + " " + to + "\n");
        move(next, to, count-1);
    }
}