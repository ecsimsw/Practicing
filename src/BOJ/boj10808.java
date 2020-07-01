package BOJ;

import java.util.Scanner;

public class boj10808 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] alphabetArr = new int[26];

        String str = sc.nextLine();

        for(char c : str.toCharArray()){
            alphabetArr[c-'a']++;
        }
    }
}