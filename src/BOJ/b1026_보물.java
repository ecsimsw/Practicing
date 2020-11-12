package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class b1026_보물{
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        String[] nums = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(nums[i]);
        }

        nums = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int sum =0;
        for(int i=0; i<n; i++){
            sum += (a[i] * b[n-i-1]);
        }

        System.out.println(sum);
    }
}
