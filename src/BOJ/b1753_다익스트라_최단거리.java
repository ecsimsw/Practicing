package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1753_다익스트라_최단거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int v = Integer.parseInt(nums[0]);
        int e = Integer.parseInt(nums[1]);
        int start = Integer.parseInt(br.readLine());

        board = new int[v][v];

        getBoard(br, e);


    }

    private static int[][] board;

    private static void getBoard(BufferedReader br, int e) throws Exception{
        for(int i=0; i<e; i++){
            String[] nums = br.readLine().split(" ");

            int from = Integer.parseInt(nums[0]) - 1;
            int to = Integer.parseInt(nums[1]) -1 ;
            int weight = Integer.parseInt(nums[2]);

            board[from][to] = weight;
        }
    }

    private static void printBoard(){
        for(int i =0; i<board.length; i++){
            for(int j= 0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dijkstra(){

    }
}
