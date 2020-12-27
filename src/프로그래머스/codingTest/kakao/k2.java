package 프로그래머스.codingTest.kakao;

/*
["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
 */

import java.util.*;

public class k2 {
    static public void main(String[] args) {
        String[] test = new String[]{"XYZ", "XWY", "WXA"};
        int[] course = new int[]{2,3,4};

        for(int i =0; i< test.length; i++){ makeSet(test[i].toCharArray(), 0, new StringBuilder()); }

        ArrayList<String> answerList = new ArrayList<>();
        for(int i: course){
            ArrayList<String> arrayList = new ArrayList<>();
            int max =2;
            for(String str : map.keySet()){
                if(str.length()==i){
                    int val  = map.get(str);
                    if(val == max){ arrayList.add(str); }
                    else if(val > max){
                        arrayList.clear();
                        arrayList.add(str);
                        max = val;
                    }
                }
            }

            for(String str : arrayList){ answerList.add(str); }
        }

        String[] answer = new  String[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        Arrays.sort(answer);
    }
    static HashMap<String, Integer> map = new HashMap<>();

    static void makeSet(char[] chars,  int index, StringBuilder set){
        if(index > chars.length){ return; }

//        System.out.println(set);

        if(set.length() >= 2) {
            set = sortSb(set);
            if(map.get(set.toString()) == null){
                map.put(set.toString(),1);
            }
            else{
                map.replace(set.toString(),map.get(set.toString())+1);
            }
        }

        for(int i=index; i<chars.length; i++){
            set = set.append(chars[i]);
            makeSet(chars, i+1, set);
            set = set.replace(set.length()-1, set.length(),"");
        }
    }

    static StringBuilder sortSb(StringBuilder sb){
       char[]  chars =  sb.toString().toCharArray();

        Arrays.sort(chars);
        StringBuilder newSb =  new StringBuilder();
        for(char c : chars){
            newSb.append(c);
        }

        return newSb;
    }
}
