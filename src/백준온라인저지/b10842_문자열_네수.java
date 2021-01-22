package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class b10842_문자열_네수 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        BigInteger AB = new BigInteger(nums[0]+nums[1]);
        BigInteger CD = new BigInteger(nums[2] + nums[3]);

        System.out.print(AB.add(CD));
    }
}
