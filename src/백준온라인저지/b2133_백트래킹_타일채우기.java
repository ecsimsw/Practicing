package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b2133_백트래킹_타일채우기_시간초과 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new boolean[3][n];
        Iboard = new int[3][n];

        Ifunc(0);

        System.out.println(ans);
    }

    private static boolean[][] board;
    private static int[][] Iboard;
    private static int n;
    private static int ans;

    private static void Ifunc(int filled){

        if(filled == 3*n){
            ans++;
            return;
        }

        if(Iboard[filled/n][filled%n] != 0){
            Ifunc(filled+1);
            return;
        }

        for(int i =0; i<2; i++){
            if(i ==0){
                if(filled%n+1 >= Iboard[0].length){
                    continue;
                }
                if(Iboard[filled/n][filled%n] == 0 && Iboard[filled/n][filled%n+1] == 0){
                    Iboard[filled/n][filled%n] = 1;
                    Iboard[filled/n][filled%n+1] = 1;
                    Ifunc(filled+1);
                    Iboard[filled/n][filled%n] = 0;
                    Iboard[filled/n][filled%n+1] = 0;
                }
            }

            if(i ==1){
                if(filled/n+1 >= 3){
                    continue;
                }

                if(Iboard[filled/n][filled%n] ==0 && Iboard[filled/n+1][filled%n]==0){
                    Iboard[filled/n][filled%n] = 2;
                    Iboard[filled/n+1][filled%n] = 2;
                    Ifunc(filled+1);
                    Iboard[filled/n][filled%n] = 0;
                    Iboard[filled/n+1][filled%n] = 0;
                }
            }
        }
    }
}
