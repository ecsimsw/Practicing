package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b1009_수학_분산처리{
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb= new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int last = 1;
            for(int l =0; l<b; l++){
                last = (last*a)%10;
            }
            if(last == 0){ sb.append(10 + "\n"); }
            else{ sb.append(last + "\n"); }
        }
        System.out.println(sb.toString());
    }
}
