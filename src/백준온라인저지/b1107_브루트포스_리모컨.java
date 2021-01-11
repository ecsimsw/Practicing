package 백준온라인저지;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1107_브루트포스_리모컨 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int numberOfBroken = Integer.parseInt(br.readLine());
        Arrays.fill(nums, true);

        for(int i =0; i<numberOfBroken; i++){
            nums[Integer.parseInt(br.readLine())] = false;
        }

        for(int i =n; )


    }

    private static int moveMin = 100000;
    private static boolean[] nums = new boolean[10];

    private static int arrowPad(int n, int now){
        return Math.abs(n-now);
    }

    private static int numPad(int i){
        int moveCnt =0;

        int digit;
        while(i>=1){
            digit = i%10;
            i /= 10;

            if(nums[digit] == false){
                return -1;
            }

            moveCnt++;
        }

        return moveCnt;
    }
}
