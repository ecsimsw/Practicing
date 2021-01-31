package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1120_문자열다루기_문자열 {
    static String[] A;
    static String[] B;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        A = line.split(" ")[0].split("");
        B = line.split(" ")[1].split("");

        int min=100;
        for(int startIndex=0; startIndex<=B.length-A.length; startIndex++){
            min = Math.min(min, compareTwoLines(startIndex));
        }

        System.out.println(min);
    }

    static int compareTwoLines(int startIndex){
        int score =0;
        for(int i = startIndex; i<A.length+startIndex; i++){
            if(!A[i-startIndex].equals(B[i])){
                score++;
            }
        }
        return score;
    }
}

class b2845_구현_파티가끝난뒤{
    //5 20
    //99 101 1000 0 97
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NL = br.readLine().split(" ");
        String[] nums = br.readLine().split(" ");

        int real = Integer.parseInt(NL[0]) * Integer.parseInt(NL[1]);

        for(String s : nums){
            System.out.print(Integer.parseInt(s) - real + " ");
        }
    }
}