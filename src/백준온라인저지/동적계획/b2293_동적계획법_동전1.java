package 백준온라인저지.동적계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2293_동적계획법_동전1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);

        moneys = new int[n];

        for(int i=0; i<n; i++){
            moneys[i] = Integer.parseInt(br.readLine());
        }

        dpBoard = new int[k+1];

        dp();
        System.out.print(dpBoard[k]);
    }

    private static int[] dpBoard;
    private static int[] moneys;

    private static void dp(){
        dpBoard[0] = 1;

        for(int i=0; i<moneys.length; i++) {
            for (int j = 1; j < dpBoard.length; j++) {
                if (j - moneys[i] < 0) {
                    continue;
                }
                dpBoard[j] = dpBoard[j] + dpBoard[j - moneys[i]];
            }
        }
    }
}
