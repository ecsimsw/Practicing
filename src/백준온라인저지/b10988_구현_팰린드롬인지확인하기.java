package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10988_구현_팰린드롬인지확인하기 {
    public static void main(String[ ] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] chars = br.readLine().split("");

        for(int i =0; i<=chars.length/2; i++){
            if(!chars[chars.length - i-1].equals(chars[i])){
                System.out.println("0");
                return;
            }
        }

        // 0 - 5
        // 1 - 4
        // 2 - 3

        System.out.println("1");
        return;
    }
}
