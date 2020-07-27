package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b7569_bfs_토마토 {
    public static void main(String[] args) throws Exception{

        BufferedReader br =new BufferedReader(new InputStreamReader( System.in));
        String[] MNH = br.readLine().split(" ");
        int M = Integer.parseInt(MNH[0]);
        int N = Integer.parseInt(MNH[1]);
        int H = Integer.parseInt(MNH[2]);

        int[][][] board = new int[H][N][M];

        for(int l=0; l<H; l++){
            for(int s =0; s<N; s++){
                String[] numbers = br.readLine().split(" ");
                for(int g =0; g<M; g++){
                    board[l][s][g] = Integer.parseInt(numbers[g]);
                }
            }
        }

        boolean[][][] isVisit = new boolean[board.length][board[0].length][board[0][0].length];

        Queue<Integer> q_l = new LinkedList<>();
        Queue<Integer> q_s = new LinkedList<>();
        Queue<Integer> q_g = new LinkedList<>();

        int zeroCount =0;
        int oneCount =0;
        int mOneCount =0;
        for(int level=0; level<board.length; level++){
            for(int col = 0; col<board[0].length; col++){
                for(int row =0; row<board[0][0].length; row++){
                    if(board[level][col][row] ==0){
                        zeroCount++;
                    }
                    if(board[level][col][row] ==-1){
                        mOneCount++;
                    }
                    if(board[level][col][row] == 1){
                        q_l.add(level);
                        q_g.add(row);
                        q_s.add(col);
                        oneCount++;
                        isVisit[level][col][row] = true;
                    }
                }
            }
        }
        if(zeroCount==0){System.out.print(0); return;}
        if(oneCount==0){System.out.print(-1); return;}

        int[] move_s = new int[]{0,0,1,-1};
        int[] move_g = new int[]{1,-1,0,0};
        boolean isFinish = false;
        int moveCount =0;

        while(!q_l.isEmpty()){
            int q = q_g.size();
            moveCount++;
            for(int move =0; move<q; move++) {

                int l = q_l.poll();
                int g = q_g.poll();
                int s = q_s.poll();

                int next_s = 0;
                int next_g = 0;
                int next_l = 0;

                for (int i = 0; i < 6; i++) {
                    switch (i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            next_l = l;
                            next_g = g + move_g[i];
                            next_s = s + move_s[i];
                            break;
                        case 4:
                            next_l = l + 1;
                            next_g = g;
                            next_s = s;
                            break;
                        case 5:
                            next_l = l - 1;
                            next_g = g;
                            next_s = s;
                            break;
                    }

                    if (next_l < 0 || next_l >= H) continue;
                    if (next_g < 0 || next_g >= M) continue;
                    if (next_s < 0 || next_s >= N) continue;
                    if (isVisit[next_l][next_s][next_g]) continue;
                    if (board[next_l][next_s][next_g] == -1) continue;

                    isVisit[next_l][next_s][next_g] = true;
                    board[next_l][next_s][next_g] = 1;
                    q_l.offer(next_l);
                    q_g.offer(next_g);
                    q_s.offer(next_s);

                    zeroCount--;
                    if (zeroCount <= 0) {
                        isFinish = true;
                        break;
                    }
                }
                if (isFinish) {
                    break;
                }
            }

            if(isFinish){
                break;
            }
        }

        if(isFinish){
            System.out.print(moveCount);
        }
        else{
            System.out.print(-1);
        }


    }
}
