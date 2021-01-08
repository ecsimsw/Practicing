package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2320_끝말잇기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new String[n];
        for(int i =0; i<n; i++){
            words[i] = br.readLine();
        }

        isUsed = new boolean[n];

        for(int i=0; i<n; i++){
            isUsed[i] = true;
            func(words[i].charAt(words[i].length()-1), words[i].length());
            isUsed[i] = false;
        }

        System.out.print(max);
    }

    private static int max =0;
    private static boolean[] isUsed;
    private static int n;
    private static String[] words;

    private static void func(char firstChar, int score){
        if(score > max){
            max = score;
        }

        for(int i=0; i<n; i++){
            if(isUsed[i] == false && words[i].charAt(0) == firstChar){
                isUsed[i] = true;
                func(words[i].charAt(words[i].length()-1), score+=words[i].length());
                isUsed[i] = false;
            }
        }
    }
}
