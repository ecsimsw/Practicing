package Programmers_AlgorithmTest.codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class UATC_3 {

}

class UATC_3_4 {
    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] board = new int[][]{
                        {3, 5, 6},
                        {9, 2, 7},
                        {4, 1, 8}
        };

        board_ = board;

        len = n;

        int score =0;

        for(int i=1; i<=len*len; i++){
            findNext(i);
            score += minMove();
            score += 1; // 엔터
        }

        int answer = score;
        System.out.println(answer);
    }
    static int len;

    static int now_x;
    static int now_y;

    static int next_x;
    static int next_y;

    static int[][] board_;
    static void findNext(int n){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(board_[i][j] == n){
                    next_x = i;
                    next_y = j;
                }
            }
        }
    }

    static int minMove(){

        int a = Math.abs(now_x-next_x) + Math.abs(now_y-next_y);
        int b = len - Math.abs(now_x-next_x) + Math.abs(now_y-next_y);
        int c = Math.abs(now_x-next_x) + len - Math.abs(now_y-next_y);
        int d = len - Math.abs(now_x-next_x) + len - Math.abs(now_y-next_y);

        return Math.min(Math.min(a,b), Math.min(c,d));
    }
}

class UATC_3_5 {
    public static void main(String[] args) throws Exception {
        String penter = "10";
        String pexit = "11";
        String pescape = "00";
        String data = "00011011";

        int size = penter.length();

        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < data.length(); index += size) {
            String nextStr = data.substring(index, index + size);
            System.out.println(nextStr + "    " + index + "    " + size);
            if (nextStr.equals(penter) || nextStr.equals(pexit) || nextStr.equals(pescape)) {
                sb.append(pescape + nextStr);
            } else {
                sb.append(nextStr);
            }
        }

        sb.insert(0, penter);
        sb.append(pexit);

        System.out.println(sb.toString());
        System.out.println(sb.length());

        String ans = "100000010010001111";
        System.out.println(ans.length());
    }
}

class UATC_3_6 {
    public static void main(String[] args) throws Exception {
        String[] logs = new String[]{
                "1901 1 100", "1901 2 100", "1901 4 100",
                "1901 7 100", "1901 8 100", "1902 2 100",
                "1902 1 100", "1902 7 100", "1902 4 100",
                "1902 8 100", "1903 8 100", "1903 7 100",
                "1903 4 100", "1903 2 100", "1903 1 100",
                "2001 1 100", "2001 2 100", "2001 4 100",
                "2001 7 95", "2001 9 100",
                "2002 1 95", "2002 2 100", "2002 4 100",
                "2002 7 100", "2002 9 100"};

        names = new LinkedList<>();
        scores = new LinkedList<>();
        cheatNames = new LinkedList<>();

        // 초기화
        for(String s : logs){
            String name = s.split(" ")[0];
            Integer p = Integer.parseInt(s.split(" ")[1]);
            Integer sc = Integer.parseInt(s.split(" ")[2]);

            if(names.contains(name)){
                Integer[] scoreBoard = scores.get(names.indexOf(name));
                scoreBoard[p] = sc;
            }else{
                names.add(name);
                Integer[] scoreBoard = new Integer[101]; // 문항 = 1~100
                Arrays.fill(scoreBoard,-1);  // 풀지 않은 문항은 -1, 풀었으나 0점인 것과 구별

                scoreBoard[p] = sc;
                scores.add(scoreBoard);
            }
        }

        // 부정행위 검색
        for(int i =0; i<names.size(); i++){
            int count_i = getCount(names.get(i));

            for(int j=i+1; j<names.size(); j++){
                int count_j = getCount(names.get(j));

                // 조건 1 확인
                // 두 수험자가 푼 문제 수가 같다. 단, 푼 문제 수가 5 미만인 경우는 제외한다.
                if(count_i == count_j && count_i>= 5){
                    if(checkBoardSame(i,j)){
                        if(!cheatNames.contains(names.get(i))){
                            cheatNames.add(names.get(i));
                        }
                        if(!cheatNames.contains(names.get(j))){
                            cheatNames.add(names.get(j));
                        }
                    }
                }
            }
        }

        Collections.sort(names);

        for(String n : cheatNames){
            System.out.println(n);
        }
    }

    static LinkedList<String> names;
    static LinkedList<Integer[]> scores;
    static LinkedList<String> cheatNames;

    static int getCount(String name){
        int index = names.indexOf(name);
        Integer[] board = scores.get(index);
        int len=0;
        for(int i : board){
            if(i != -1){ // 안푼 것 -1이 아니면 len ++
                len++;
            }
        }
        return len;
    }

    static boolean checkBoardSame(int i, int j){

        Integer[] scBoard_i = scores.get(i);
        Integer[] scBoard_j = scores.get(j);

        // 사이즈가 같다는 조건 하에 점수판이 동일한지 체크
        for(int index=0; index<scBoard_i.length; index++){
            // 조건 2, 3
            if(scBoard_i[index] == scBoard_j[index]){
                continue;
            }
            else{ return false; }
        }

        return true;
    }
}

class UATC_3_7 {
    public static void main(String[] args) throws Exception {
        n = 5;
        boolean horizontal = false;

        board = new int[n][n];

        board[s][g] = sec;

        if(horizontal){
            // 우로 이동
            g++;
            sec++;
            board[s][g] = sec;
        }
        else{
            // 좌로 이동
            s++;
            sec++;
            board[s][g] = sec;
        }

        while(s<n && g<n){
            horizontal = horizontal==true ? false : true;
            move(horizontal);
        }

        for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int sec =0;
    static int n;
    static int[][] board;

    static int s;
    static int g;

    static void move(boolean isUp){
        if(isUp){
            while(s<n && g<n){
                System.out.println(s + " "+ g + " up");
                // 대각 위 이동
                s--;
                g++;
                sec += 2;

                if(s>=n || g>=n){ break; }
                board[s][g] = sec;

                if(g+1 >= n ){
                    // 오른쪽 이동 불가능하면 아래로
                    sec +=1;
                    s++;
                    board[s][g] =sec;
                    break;
                }
                if(s-1 < 0 ) {
                    // 위 이동 불가능하면 오른쪽으로
                    sec +=1;
                    g++;
                    board[s][g] =sec;
                    break;
                }
            }
        }
        else{
            while(s<n && g<n){
                System.out.println(s + " "+ g + " down");
                // 대각 아래 이동
                s++;
                g--;
                sec += 2;

                if(s>=n || g>=n){ break; }
                board[s][g] = sec;

                if(s+1 >= n ){
                    // 아래 이동 불가능하면 오른쪽으로
                    sec +=1;
                    g++;
                    board[s][g] =sec;
                    break;
                }
                if(g-1 < 0 ) {

                    // 왼쪽으로 이동 불가능하면 아래로
                    sec +=1;
                    s++;
                    board[s][g] =sec;
                    break;
                }
            }
        }

        return;
    }

}