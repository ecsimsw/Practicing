package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1673_규칙_치킨쿠폰 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String line = br.readLine();

            if(line == null) break;

            String[] str = line.split(" ");

            int coupon = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);

            Long time = System.currentTimeMillis();

            int count =0;
            int newCoupon;
            int newCount;

            while(true){
                newCount = (coupon - coupon%k);
                newCoupon = newCount/k;
                coupon = coupon%k;
                coupon += newCoupon;

                count += newCount;
                if(coupon < k) {
                    count += coupon;
                    break;
                }
            }

            System.out.println(count);
            System.out.println(System.currentTimeMillis()-time);
        }
    }
}
