package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class b4179_bfs_불 {


    static int[] m_s = {0,1,0,-1};
    static int[] m_g = {1,0,-1,0};

    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> fire = new LinkedList<>();

    static public void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int l_g = Integer.parseInt(line[1]);
        int l_s = Integer.parseInt(line[0]);

        char[][] board = new char[l_s][l_g];

        for(int i=0; i<l_s; i++){
            String[] chars = br.readLine().split("");
            for(int j=0; j<l_g; j++) {
                board[i][j] = chars[j].charAt(0);
            }
        }

        Point J = null;
        Point F = null;

        for(int i=0; i<l_s; i++){
            for(int j=0; j<l_g; j++){
                if(board[i][j] == 'J') {
                    queue.offer(new Point(i,j));
                }
                if(board[i][j] == 'F') {
                    fire.offer(new Point(i,j));
                }
            }
        }

        int n =0;
        boolean finish = false;

        int nextS;
        int nextG;

        while(!queue.isEmpty()){
            Point now = queue.poll();

            int numberOfFire = fire.size();
            for(int f=0; f<numberOfFire; f++) {
                Point fireBoarder = fire.poll();

                for (int i = 0; i < 4; i++) {
                    nextS = fireBoarder.s + m_s[i];
                    nextG = fireBoarder.g + m_g[i];

                    if (nextS > -1 && nextG > -1 && nextG < l_g && nextS < l_s && board[nextS][nextG] != '#') {
                        board[nextS][nextG] = 'F';
                        fire.offer(new Point(nextS, nextG));
                    }
                }
            }

            for(int i=0; i<4; i++){
                nextS = now.s + m_s[i];
                nextG = now.g + m_g[i];

                if(nextS == l_s || nextG == l_g || nextS == 0 || nextG ==0){
                    finish = true;
                    break;
                }

                if(nextS>-1 && nextG > -1 && nextG < l_g && nextS < l_s) {
                    if (board[nextS][nextG] == '.') {
                        board[nextS][nextG] = 'J';
                        queue.offer(new Point(nextS, nextG));
                    }
                }
            }

            n++;

            if(finish){ break; }
        }

        if(finish) System.out.println(n);
        else System.out.println("IMPOSSIBLE");
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