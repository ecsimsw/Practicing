package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
class b1929_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numstr = br.readLine().split(" ");

        int M = Integer.parseInt(numstr[0]);
        int N = Integer.parseInt(numstr[1]);

        int[] prime = new int[1000000];
        int primeCnt =0;
        for(int i=M; i<=N; i++){
            if(i % 2 ==0|| i % 3 ==0|| i % 5==0 || i %7==0 || i% 11==0 || i %13==0){
                continue;
            }
            boolean isPrime = true;
            for(int p=0; p<primeCnt; p++){
                if(i%prime[p]==0){ isPrime = false; }
            }
            if(isPrime){ prime[primeCnt++] = i;
            System.out.println(i);}
        }

        int[] beforePrime = new int[]{2,3,5,7,11,13};

        for(int b : beforePrime){
            if(b<M) continue;
            System.out.println(b);
        }
        for(int p : prime) {
            if (p == 0) break;
            System.out.println(p);
        }
    }
}
*/
class b1978_소수_소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        int cnt=0;

        String[] numstr = br.readLine().split(" ");

        int index =0;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(numstr[i]);
            if(num == 1) continue;
            if(num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num ==13){
                cnt++;
                continue;
            }
            if(num <= 13) continue;
            nums[index++] = num;
        }

        Arrays.sort(nums);

        int[] prime = new int[1000];
        int primeCnt =0;
        for(int i=2; i<=1001; i++){
            if(i % 2 ==0|| i % 3 ==0|| i % 5==0 || i %7==0 || i% 11==0 || i %13==0){
                continue;
            }
            boolean isPrime = true;
            for(int p=0; p<primeCnt; p++){
                if(i%prime[p]==0){
                    isPrime = false;
                }
            }
            if(isPrime){
                prime[primeCnt++] = i;
            }

            if(i == nums[nums.length-1]) break;
        }

        for(int i : nums){
            boolean isPrime = true;
            for(int p :prime ){
                if(i<p)break;
                if(i == p){
                    cnt++;
                    break;
                }
            }
        }
        System.out.print(cnt);

    }
}
