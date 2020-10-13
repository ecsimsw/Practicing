package BOJ;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class b1987_bfs_알파벳 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] splited = str.split(" ");

        R = Integer.parseInt(splited[0]);
        C = Integer.parseInt(splited[1]);

//        board = new char[R][C];
//
//        for(int i=0; i<R; i++){
//            String line = br.readLine();
//            splited = line.split(" ");
//
//            for(int j=0; j<C; j++){
//                board[i][j] = splited[j].charAt(0);
//            }
//        }

        board = new char[][]{
                {'C','A','A','B'},
                {'A','D','C','B'}
        };


    }

    static char[][] board;

    static int R;
    static int C;

    static int[] move_g = {0,0,1,-1};
    static int[] move_s = {1,-1,0,0};

    static int bfs(){

        Queue<Integer> queue_g = new LinkedList();
        Queue<Integer> queue_s = new LinkedList();

        HashSet<Character> passed = new HashSet<>();

        queue_g.offer(0);
        queue_s.offer(0);

        while(!queue_g.isEmpty()){
            int s = queue_s.poll();
            int g = queue_g.poll();
        }
    }

}
