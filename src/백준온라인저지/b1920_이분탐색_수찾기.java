package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class b1920_이분탐색_수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer,Boolean> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] numstr =  br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(numstr[i]);
            map.put(nums[i], true);
        }

        n = Integer.parseInt(br.readLine());
        numstr =  br.readLine().split(" ");
        int[] find = new int[n];
        for(int i=0; i<n; i++){
            find[i] = Integer.parseInt(numstr[i]);
        }

        for(int f : find){
            if(map.get(f)!=null){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}

