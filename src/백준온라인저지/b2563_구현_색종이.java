package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2563_구현_색종이 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] board = new boolean[200][200];

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y= Integer.parseInt(line[1]);

            for(int g = x; g < x+10; g++){
                for(int s = y; s<y+10; s++){
                    board[s][g] = true;
                }
            }
        }

        int score =0;
        for(int i =0; i<200; i++){
            for(int j=0; j<200; j++){
                if(board[i][j]){
                    score++;
                }
            }
        }

        System.out.print(score);
    }
}
