package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class b1764_이분탐색_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        HashSet<String> set1 = new HashSet<String>();
        for(int i=0; i<n; i++){
            set1.add(br.readLine());
        }
        HashSet<String> set2 = new HashSet<String>();
        for(int i=0; i<m; i++){
            set2.add(br.readLine());
        }

        LinkedList<String> answers = new LinkedList<>();
        for(String s : set1){
            if(set2.contains(s)){
                answers.add(s);
            }
        }

        Collections.sort(answers);
        System.out.println(answers.size());
        for(String s : answers) {
            System.out.println(s);
        }
    }
}


