package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2480_구현_주사위세개 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];

        String[] nums = br.readLine().split(" ");
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }

        int same =1;
        for(int j=1; j<3; j++){
            if(arr[0] == arr[j]){
                same++;
            }
        }

        if(same == 3){
            System.out.println(10000+arr[0]*1000);
            return;
        }

        if(same == 2){
            System.out.println(1000+arr[0]*100);
            return;
        }

        if(arr[1] == arr[2]){
            System.out.println(1000+arr[1]*100);
            return;
        }

        System.out.println(Math.max(Math.max(arr[0], arr[1]), arr[2])*100);
    }
}
