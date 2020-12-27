package 백준온라인저지;

import java.util.Scanner;

public class b10808_Array_알파벳 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] alphabetArr = new int[26];

        String str = sc.nextLine();

        for(char c : str.toCharArray()){
            alphabetArr[c-'a']++;
        }
    }
}