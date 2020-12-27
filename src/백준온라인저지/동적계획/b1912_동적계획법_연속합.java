package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1912_동적계획법_연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];

        String[] nums = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            board[i] = Integer.parseInt(nums[i]);
        }

        int[] newBoard = new int[n];

        int cnt =0;
        boolean sw = Math.abs(board[0]) == board[0];
        int sum =0;
        for(int i=0; i<n; i++){
            boolean tempSw = Math.abs(board[i]) == board[i];
            if( tempSw == sw){
                sum+=board[i];
            }
            else{
                newBoard[cnt] = sum;
                sum=board[i];
                sw = sw == true ? false: true;
                cnt++;
            }
        }
        newBoard[cnt] = sum;
        cnt++;

        int[][] dpBoard = new int[cnt][cnt];
        for(int i =0; i<cnt; i++){
            dpBoard[i][i] = newBoard[i];
        }

        for(int i =0; i<cnt; i++) {
            for(int j= i+1; j<cnt; j++){
                dpBoard[i][j] = dpBoard[i][j-1]+newBoard[j];
            }
        }
        int max= 0;
        for(int i =0; i<cnt; i++){
            for(int j=i; j<cnt; j++){
                if(max < dpBoard[i][j]){
                    max = dpBoard[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
