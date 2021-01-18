package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b1062_해시_가르침 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        n = Integer.parseInt(NK[0]);
        k = Integer.parseInt(NK[1]);

        lines = new String[n];

        for(int i=0; i<n; i++){
            lines[i] = br.readLine();
        }

        usedAlphabet = new LinkedList<>();
        usedAlphabet.add("a");
        usedAlphabet.add("n");
        usedAlphabet.add("t");
        usedAlphabet.add("i");
        usedAlphabet.add("c");

        for(int i =0; i<n; i++){
            String[] characters = lines[i].split("");
            for(String s : characters){
                if(!usedAlphabet.contains(s)){
                    usedAlphabet.add(s);
                }
            }
        }

        learned = new boolean[26];
        learned[(char)'a' - 'a'] = true;
        learned[(char)'n' - 'a'] = true;
        learned[(char)'t' - 'a'] = true;
        learned[(char)'i' - 'a'] = true;
        learned[(char)'c' - 'a'] = true;

        findMax(5, 0);

        System.out.print(max);
    }

    private static boolean[] learned;
    private static LinkedList<String> usedAlphabet;
    private static String[] lines;
    private static int n;
    private static int k;

    private static int max =0;

    private static void findMax(int learnedCnt, int fromIndex){
        if(learnedCnt == k) {
            int cnt = countLearnedWord();
            max = Math.max(max, cnt);
            return;
        }

        for(int i = fromIndex; i<usedAlphabet.size(); i++){
            int index = (char)usedAlphabet.get(i).charAt(0) - 'a';
            if(learned[index] == false){
                learned[index] = true;
                findMax(learnedCnt+1, i);
                learned[index] = false;
            }
        }
    }

    private static int countLearnedWord(){
        int count =0;
        for(String s : lines){
            boolean isLearend = true;
            for(char c : s.toCharArray()){
                if(learned[c-'a'] == false){
                    isLearend = false;
                    break;
                }
            }

            if(isLearend){
                count++;
            }
        }

        return count;
    }
}
