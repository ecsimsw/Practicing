package 프로그래머스.codingTest.WC_2020;

import java.util.*;

public class WinterCoding_2020 {

}

class WinterCoding_2020_1 {
    public String solution(int n, int[][] delivery) {

        int[][] del = delivery;

        int[] arr = new int[n+1]; // 0 -> ? , -1 -> x , 1 -> o

        for(int i =0; i<del.length; i++){
            int left = del[i][0];
            int right = del[i][1];
            int r = del[i][2];

            if(r == 1){
                arr[left] = 1;
                arr[right] = 1;
            }

            else if(r == 0){
                if(arr[left]==1){
                    arr[right] = -1;
                }
                else if(arr[right]==1){
                    arr[left] =-1;
                }
            }
        }

        for(int i =0; i<del.length; i++){
            int left = del[i][0];
            int right = del[i][1];
            int r = del[i][2];

            if(r == 1){
                arr[left] = 1;
                arr[right] = 1;
            }

            else if(r == 0){
                if(arr[left]==1){
                    arr[right] = -1;
                }
                else if(arr[right]==1){
                    arr[left] =-1;
                }
            }
        }

        String answer = "";

        for(int i =1; i<=n; i++){
            String r = (arr[i] == 1 ? "O" : (arr[i]==0? "?" : "X"));
            answer += r;
        }

        return answer;
    }
}

class WinterCoding_2020_2 {
    public String solution(String encrypted_text, String key, int rotation) {

        int l = encrypted_text.length();
        char[] encrypted_char = encrypted_text.toCharArray();
        char[] key_char = key.toCharArray();


        char[] result = new char[encrypted_char.length];

        rotation = (Math.abs(rotation) % l) * Math.abs(rotation) / rotation;

        int start =0;

        start = rotation * -1;
        if(rotation>0){start = rotation;}
        if(rotation<0){start = l + rotation;}

        int index = start;
        int ia =0;
        do{
            result[ia++] = encrypted_char[index];
            index++;
            if(index >= l){
                index = index - l;
            }
        }while(index != start);

        char[] result_second = new char[l];

        for(int i=0; i<l; i++){
            int sum = (int)result[i] - (int)key_char[i];
            sum += 96;
            if(sum <97 ){ sum = 122 + sum-96;}
            result_second[i] = (char)sum;
        }
        // 97 122

        String answer = "";

        for(char c : result_second){
            answer += c;
        }

        return answer;
    }
}

class WinterCoding_2020_3 {
    public int[] solution(int[][] v)
    {
        n = v.length;
        board = v;

        visited = new boolean[n][n];

        dfs();

        int[] answer = new int[3];

        answer[0] = m;
        answer[1] = sw;
        answer[2] = p;

        return answer;
    }

    static int[] move_s = new int[]{0,0,1,-1};
    static int[] move_g = new int[]{1,-1,0,0};

    static int m; // 무
    static int sw; // 고구마
    static int p; // 감자

    static int[][] board;
    static boolean[][] visited;
    static int n;

    static void dfs(){
        for(int s=0; s<n; s++){
            for(int g=0; g<n; g++){
                if(visited[s][g] == true) continue;
                countSameArea(s,g);
            }
        }
    }

    static void countSameArea(int s, int g){

        int first = board[s][g];

        if(board[s][g] == 0) m++;
        if(board[s][g] == 1) sw++;
        if(board[s][g] == 2) p++;

        LinkedList<Integer> queue_s = new LinkedList<>();
        LinkedList<Integer> queue_g = new LinkedList<>();

        queue_s.add(s);
        queue_g.add(g);
        visited[s][g] = true;

        while(!queue_s.isEmpty()){
            int now_s = queue_s.poll();
            int now_g = queue_g.poll();

            for(int i=0; i<4; i++){
                int next_s = now_s + move_s[i];
                int next_g = now_g + move_g[i];

                if(next_s <0 || next_s >=n || next_g <0 || next_g >=n) continue;
                if(visited[next_s][next_g] == true) continue;
                if(board[next_s][next_g] != first) continue;

                queue_s.offer(next_s);
                queue_g.offer(next_g);

                visited[next_s][next_g] = true;
            }
        }
    }
}
