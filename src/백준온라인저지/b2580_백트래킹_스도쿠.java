package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2580_백트래킹_스도쿠 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        board = new int[9][9];

        for(int i =0; i<9; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        zeroCnt =0;
        for(int i=0; i<9; i++){
            for(int k=0; k<9; k++) {
                if(board[i][k] == 0){
                    zeroCnt++;
                }
            }
        }

        zeroPoint = new Point[zeroCnt];
        int cnt =0;
        for(int i=0; i<9; i++){
            for(int k=0; k<9; k++) {
                if(board[i][k] == 0){
                    zeroPoint[cnt] = new Point(i,k);
                    cnt++;
                }
            }
        }

        func(0);

    }

    static int func(int index) {
        if(index == zeroCnt){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return 1;
        }

        Point p = zeroPoint[index];

        boolean[] check = checker(p.s, p.g);

        for(int i=1; i<10; i++){ if(check[i] == false){
               board[p.s][p.g] = i;
               if(func(index+1)== 1){return 1;};
               board[p.s][p.g] = 0;
           }
        }

        return 0;
    }

    static Point[] zeroPoint;
    static int zeroCnt;
    static int[][] board;

    static boolean[] checker(int s, int g) {
        boolean[] check = new boolean[10];
        check[0] = true;

        for (int i = s / 3 * 3; i < s / 3 * 3 + 3; i++) {
            for (int j = g / 3 * 3; j < g / 3 * 3 + 3; j++) {
                check[board[i][j]] = true;
            }
        }

        for (int i = 0; i < 9; i++) check[board[s][i]] = true;
        for (int i = 0; i < 9; i++) check[board[i][g]] = true;

        return check;
    }
}
class Point{
    int s;
    int g;
    public Point(int s, int g){
        this.s = s;
        this.g = g;
    }
}
