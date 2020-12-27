package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2042_구현_구간합구하기 {
    static public void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int k = Integer.parseInt(nums[2]);

        long[] arr= new long[n];

        for(int i=0; i<n; i++){ arr[i] = Long.parseLong(br.readLine()); }

        for(int i=0; i<m+k; i++){
            nums = br.readLine().split(" ");

            if(nums[0].equals("1")){
                arr[Integer.parseInt(nums[1])-1] = Long.parseLong(nums[2]);
            }
            else{
                int start = Integer.parseInt(nums[1])-1;
                int end = Integer.parseInt(nums[2])-1;
                long sum =0;
                for(int index = start; index<=end; index++){ sum += arr[index]; }
                sb.append(sum+"\n");
            }
        }

        System.out.print(sb.toString());
    }
}

class b2042_구현_구간합구하기_시간초과 {
    static public void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int k = Integer.parseInt(nums[2]);

        long[] arr= new long[n];

        for(int i=0; i<n; i++){ arr[i] = Long.parseLong(br.readLine()); }

        for(int i=0; i<m+k; i++){
            nums = br.readLine().split(" ");

            if(nums[0].equals("1")){
                arr[Integer.parseInt(nums[1])-1] = Long.parseLong(nums[2]);
            }
            else{
                int start = Integer.parseInt(nums[1])-1;
                int end = Integer.parseInt(nums[2])-1;
                long sum =0;
                for(int index = start; index<=end; index++){ sum += arr[index]; }
                sb.append(sum+"\n");
            }
        }

        System.out.print(sb.toString());
    }
}
