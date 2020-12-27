package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11053_동적계획법_가장긴증가하는부분수열 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int[] board = new int[n];
        for(int i =0; i<n; i++){
            board[i]  = Integer.parseInt(nums[i]);
        }

        int[] dpBoard = new int[n];

        for(int i=0; i<n; i++){

            boolean isMin = true;
            int maxDp =0;
            for(int j=0; j<i; j++){
                if(board[i] > board[j]){
                    if(maxDp < dpBoard[j]){
                        maxDp = dpBoard[j];
                        dpBoard[i] = dpBoard[j]+1;
                        isMin = false;
                    }
                }
            }
            if(isMin){
                dpBoard[i] = 1;
            }
        }


        int max = 0;
        for(int i : dpBoard){
            System.out.print(i+" ");
//            if(max < i) max = i;
        }

//        System.out.print(max);
    }
}
