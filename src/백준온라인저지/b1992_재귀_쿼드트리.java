package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1992_재귀_쿼드트리 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        String r = func(0,0,board.length);
        System.out.println(r);
    }

    static int[][] board;
    static Stack<String> stack = new Stack<>();

    static int i1;
    static int i2;
    static int i3;
    static int i4;
    static int sum;

    //static String r1;   이건 전역으로 하면 안된다.
    //static String r2;
    //static String r3;
    //static String r4;

    static StringBuilder sb = new StringBuilder();

    static String func(int s, int g, int N){
        if(N == 2){
            i1 = board[s][g];
            i2 = board[s][g+1];
            i3 = board[s+1][g];
            i4 = board[s+1][g+1];
            sum = i1+i2+i3+i4;

            if(sum==0) {
                return "0";
            }
            else if(sum == 4){
                return "1";
            }
            else{
                sb.delete(0,sb.length());
                sb.append("(");
                sb.append(i1);
                sb.append(i2);
                sb.append(i3);
                sb.append(i4);
                sb.append(")");
                return sb.toString();
            }
        }

        N /= 2;

        String r1 = func(s,g,N);
        String r2 = func(s,g+N,N);
        String r3 = func(s+N,g,N);
        String r4 = func(s+N,g+N,N);

        try{
            i1 = Integer.parseInt(r1);
            i2 = Integer.parseInt(r2);
            i3 = Integer.parseInt(r3);
            i4 = Integer.parseInt(r4);
            sum = i1+i2+i3+i4;

            if(sum==0) {
                return "0";
            }
            else if(sum == 4){
                return "1";
            }
            else{
                sb.delete(0,sb.length());
                sb.append("(");
                sb.append(i1);
                sb.append(i2);
                sb.append(i3);
                sb.append(i4);
                sb.append(")");
                return sb.toString();
            }
        }
        catch (Exception e){
            sb.delete(0,sb.length());
            sb.append("(");
            sb.append(r1);
            sb.append(r2);
            sb.append(r3);
            sb.append(r4);
            sb.append(")");
            return sb.toString();
        }
    }
}
