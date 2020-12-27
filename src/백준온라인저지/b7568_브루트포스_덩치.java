package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b7568_브루트포스_덩치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] weights = new int[n];
        int[] heights = new int[n];

        for(int j =0; j<n; j++){
            String[] line = br.readLine().split(" ");

            weights[j] = Integer.parseInt(line[0]);
            heights[j] = Integer.parseInt(line[1]);
        }
        int[] rate = new int[n];

        for(int member =0; member<n; member++){
            rate[member] =1;
            for(int other =0; other<n; other++){
                if(weights[member]<weights[other] && heights[member]<heights[other]){
                    rate[member]++;
                }
            }
        }

        for(int r : rate){System.out.print(r + " ");}
    }
}
