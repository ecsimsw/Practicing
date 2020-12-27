package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b10816_숫자카드2{
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[20000001];

        String[] nums = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int score = 10000000 + Integer.parseInt(nums[i]);
            arr[score]++;
        }

        int n_ = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        nums = br.readLine().split(" ");
        for(int i=0; i<n_; i++){
            int score = 10000000 + Integer.parseInt(nums[i]);
            sb.append(arr[score]+" ");
        }
        System.out.print(sb);

    }
}
