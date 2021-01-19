package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class b1062_백트래_가르침 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        n = Integer.parseInt(NK[0]);
        k = Integer.parseInt(NK[1]);

        lines = new String[n];

        for(int i=0; i<n; i++){
            lines[i] = br.readLine();
        }

        if(k < 5){
            System.out.print("0");
            return;
        }

        if(k >= 26){
            System.out.print(n);
            return;
        }

        usedAlphabet = new ArrayList<>();

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
    private static ArrayList<String> usedAlphabet;
    private static String[] lines;
    private static int n;
    private static int k;

    private static int max =0;

    private static void findMax(int learnedCnt, int fromIndex) {
        if (learnedCnt <= k) {
            int cnt = countLearnedWord();
            max = Math.max(max, cnt);
            return;
        }

        // 차라리 아예 26개 알파벳을 다 도는 것이 아래 내 풀이보다 효율적이다.
        for (int i = fromIndex; i < 26; i++) {
            int index = i;
            if (learned[index] == false) {
                learned[index] = true;
                findMax(learnedCnt + 1, i + 1);
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

class b1062_백트래킹_가르침_내풀이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        n = Integer.parseInt(NK[0]);
        k = Integer.parseInt(NK[1]);

        lines = new String[n];

        for(int i=0; i<n; i++){
            lines[i] = br.readLine();
        }

        if(k < 5){
            System.out.print("0");
            return;
        }

        if(k >= 26){
            System.out.print(n);
            return;
        }

        usedAlphabet = new ArrayList<>();

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
    private static ArrayList<String> usedAlphabet;
    private static String[] lines;
    private static int n;
    private static int k;

    private static int max =0;

    private static void findMax(int learnedCnt, int fromIndex) {
        if (learnedCnt == k) {
            // 이렇게 하면 문제가, 배워야하는 알파벳보다 배울 수 있는 알파벳(k)가 더 큰 상황을 놓친다.
            // 예를 들면 10개를 배울 수 있는데, 배워야하는 알파벳이 3개 뿐이라면?
            // max를 수정하지 못 한채 함수가 종료될 것이다.
            // 만약 이렇게 하고 싶다면, learnedCnt 가 k개수 이하 일때도 매번 if문을 처리해야한다.
            int cnt = countLearnedWord();
            max = Math.max(max, cnt);
            return;
        }

        for (int i = fromIndex; i < usedAlphabet.size(); i++) {
            int index = (char) usedAlphabet.get(i).charAt(0) - 'a';
            if (learned[index] == false) {
                learned[index] = true;
                findMax(learnedCnt + 1, i + 1);
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
