package javaPracticing;

import java.math.BigInteger;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        int h=0;

        for(int i=1; i<=10; ++i)
        {
            // 루틴 시작
            h+=i;
            // 루틴 끝
        }

        h=0;
        int i=1;
        while(true){
            if(!(i<=10)) break;
            // 루틴 시작
            h+=i;
            // 루틴 끝
            ++i;
        }

        System.out.print(h);
    }
}
