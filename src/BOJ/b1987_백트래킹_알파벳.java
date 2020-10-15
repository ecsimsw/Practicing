package BOJ;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class b1987_백트래킹_알파벳 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] splited = str.split(" ");

        R = Integer.parseInt(splited[0]);
        C = Integer.parseInt(splited[1]);

        board = new char[R][C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            splited = line.split("");

            for(int j=0; j<C; j++){
                board[i][j] = splited[j].charAt(0);
            }
        }

        int s = 0;
        int g = 0;

        Set<Character> passed = new HashSet<>();
        passed.add(board[s][g]);
        max = 1;
        int r = search(s,g, passed);

        System.out.println(r);
    }

    static char[][] board;

    static int R;
    static int C;

    static int[] move_g = {0,0,1,-1};
    static int[] move_s = {1,-1,0,0};

    static int max= 0;

    static int search(int s, int g, Set<Character> passed){
        for(int i=0; i<4; i++){


            int next_s = s+move_s[i];
            int next_g = g+move_g[i];

            if(next_s<0 || next_s >= R){continue;}
            if(next_g<0 || next_g >= C){continue;}

            char c = board[next_s][next_g];
            if(passed.contains(c)){continue;}

            passed.add(c);

            int point = passed.size();
            if(point > max){ max = point; }

            search(next_s, next_g, passed);
            passed.remove(c);
        }

        return max;
    }

}
