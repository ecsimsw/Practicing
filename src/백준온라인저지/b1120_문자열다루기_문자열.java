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
