package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b3009_네번째점{
    static public void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int[] xArr = new int[3];
        int[] yArr = new int[3];

        for(int i=0; i<3; i++){
            String[] nums = br.readLine().split(" ");
            xArr[i] = Integer.parseInt(nums[0]);
            yArr[i] = Integer.parseInt(nums[1]);
        }

        int difX =0;
        int difY =0;

        difX = (xArr[0] == xArr[1])? xArr[2] : (xArr[0] == xArr[2]) ? xArr[1] : xArr[0];
        difY = (yArr[0] == yArr[1])? yArr[2] : (yArr[0] == yArr[2]) ? yArr[1] : yArr[0];

        System.out.println(difX + " "+ difY);

    }
}
