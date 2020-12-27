package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2805_이분탐색_나무자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int treeCnt = Integer.parseInt(line[0]);
        int goal = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");

        int[] trees = new int[treeCnt];

        int maxHeight = 0;

        for(int i =0; i< treeCnt; i++){
            trees[i] = Integer.parseInt(line[i]);
            if(maxHeight < trees[i]){ maxHeight = trees[i]; }
        }

        int left = maxHeight - goal;
        int right = maxHeight;

        long totalGet;
        int middle=0;
        while(true){
            middle = (left + right)/2;
            totalGet =0;
            for(int h : trees){
                if(h-middle >0){ totalGet += (h-middle); }
            }

            if(totalGet == goal){ break; }
            else if(totalGet < goal){
                right = middle-1;
            }
            else if(totalGet > goal){
                totalGet =0;
                for(int h : trees){
                    if(h-(middle+1) >0){ totalGet += (h-(middle+1)); }
                }
                if(totalGet<goal){ break; }

                left = middle+1; }
        }

        System.out.println(middle);
    }
}
