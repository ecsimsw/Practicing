package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class b1181_정렬_단어정렬 {
    static class Word implements Comparable{
        String word;

        public Word(String str){
            this.word = str;
        }

        public int compareTo(Object o){
            if(o instanceof Word){
                Word temp = (Word)o;
                if(this.word.length() < temp.word.length()){return -1;}
                else if(this.word.length() == temp.word.length()){
                    return this.word.compareTo(temp.word);
                }
                else return 1;
            }
            else return 0;
        }

        public int hashCode(){
            return word.hashCode();
        }

        public boolean equals(Object o){
            if(o instanceof Word){
                Word w = (Word)o;
                return w.word.equals(this.word);
            }
            return false;
        }
    }

    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet set = new HashSet();

        for(int i=0; i<n; i++){
            set.add(new Word(br.readLine()));
        }

        LinkedList<Word> list = new LinkedList<>(set);

        Collections.sort(list);

        for(Word word : list){
            System.out.println(word.word);
        }
    }
}
