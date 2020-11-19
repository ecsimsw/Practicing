package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b2609_수학_최대공약수와최소공배수{
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        int gcd = gcd(n,m);
        int lcm = lcm(n,m);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int a, int b){
        while(a!=b){
            if(a>b){ a = a-b; }
            if(b>a){ b = b-a; }
        }
        return a;
    }

    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
