package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b18808_시뮬레이션_스티커붙이기 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = br.readLine().split(" ");

        int N = Integer.parseInt(numbers[0]);
        int M = Integer.parseInt(numbers[1]);
        int stickerCnt = Integer.parseInt(numbers[2]);

        board = new int[N][M];

        stickers = new int[stickerCnt][][];

        for(int i=0; i<stickerCnt; i++){
            String[] sg = br.readLine().split(" ");

            int s = Integer.parseInt(sg[0]);
            int g = Integer.parseInt(sg[1]);

            int[][] sticker = new int[s][g];

            for(int a =0; a<s; a++){
                String[] nums = br.readLine().split(" ");
                for(int b=0; b<g; b++){
                    sticker[a][b] = Integer.parseInt(nums[b]);
                }
            }
            stickers[i] = sticker;
        }

        for(int i=0; i<stickers.length; i++){
            for(int turnCnt=0; turnCnt<4; turnCnt++){
                if(isMatch(stickers[i])){ break; }
                else{ stickers[i] = turn(stickers[i]); }
            }
        }

        int cnt =0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] ==1) cnt++;
            }
        }
        System.out.print(cnt);
    }

    static int[][] board;
    static int[][][] stickers;


    static void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean isMatch(int[][] sticker){
        for(int i=0; i<board.length-sticker.length+1; i++){
            for(int j=0; j<board[0].length - sticker[0].length+1; j++){
                boolean allFit = true;
                for(int s=0; s<sticker.length; s++){
                    for(int g=0; g<sticker[0].length; g++){
                        if(sticker[s][g]==0) continue;
                        if(board[i+s][j+g]==1){
                            allFit = false; break;
                        }
                    }
                    if(allFit == false) break;
                }
                if(allFit == true) {
                    for(int s=0; s<sticker.length; s++){
                        for(int g=0; g<sticker[0].length; g++){
                            if(sticker[s][g]==0) continue;
                            board[i+s][j+g]=1;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] turn(int[][] sticker){
        int[][] result = new int[sticker[0].length][sticker.length];
        for(int i=0; i<sticker.length; i++){
            for(int j=0; j<sticker[0].length; j++){
                result[j][sticker.length-i-1] = sticker[i][j];
            }
        }
        return result;
    }
}
