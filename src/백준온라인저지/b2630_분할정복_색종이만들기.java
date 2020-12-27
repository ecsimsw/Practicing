package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2630_분할정복_색종이만들기 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        func(0,0,N);
        System.out.println(count_b);
        System.out.println(count_w);
    }
    static int[][] board;

    static int count_w;
    static int count_b;

    static void func(int s, int g, int n){

        int r  =  isAllSame(s,g,n);

        if(r != -1){
            if(r ==1) count_w++;
            else count_b++;
            return;
        }

        if(n <= 1) return;

        n = n/2;
        func(s,g, n);
        func(s+n, g, n);
        func(s, g+n, n);
        func(s+n, g+n, n);
    }

    static int isAllSame(int s, int g, int size){
        int first = board[s][g];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[s+i][g+j] != first){
                    return -1;
                }
            }
        }
        return first;
    }
}
