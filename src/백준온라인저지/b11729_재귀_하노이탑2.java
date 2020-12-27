package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11729_재귀_하노이탑2 { }

// Print를 여러번 하는 방식

class 재귀_하노이탑1 {
    static int n=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long now = System.currentTimeMillis();
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2,N)-1);
        move(1,3,N);
        System.out.println(System.currentTimeMillis()-now);
        System.out.println(n);
    }

    static void move(int from, int to, int count){
        if(count ==1) {
            System.out.println(from + " " + to);
            n++;
            return;
        }
        int next = 6- from- to;
        move(from, next, count-1);
        System.out.println(from+" "+to);
        n++;
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