package 프로그래머스.codingTest.kakao;

import java.util.LinkedList;

/*
개발언어는 cpp, java, python 중 하나입니다.
직군은 backend, frontend 중 하나입니다.
경력은 junior, senior 중 하나입니다.
소울푸드는 chicken, pizza 중 하나입니다.
점수는 코딩테스트 점수를 의미하며, 1 이상 100,000 이하인 자연수입니다.
 */
public class k3 {
    static public void main(String[] args){
        String[] test = new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] asked = new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] answer = new int[asked.length];

        int[][] board = new int[24][100001];

        for(String s : test) {
            board[converter(s)][Integer.parseInt(s.split(" ")[4])]++;
        }

        int index=0;
        for(String ask : asked){
            String[] askSplited = ask.split("and ");

            int moreScore = Integer.parseInt(askSplited[3].split(" ")[1]);

            askSplited[3] = askSplited[3].split(" ")[0];

            LinkedList<StringBuilder> inputs_0 = new LinkedList<>();
            if(askSplited[0].charAt(0)=='-'){
                inputs_0.add(new StringBuilder("j "));
                inputs_0.add(new StringBuilder("c "));
                inputs_0.add(new StringBuilder("p "));
            }
            else{
                inputs_0.add(new StringBuilder(""+askSplited[0].toCharArray()[0]+" "));
            }

            LinkedList<StringBuilder> inputs_1 = new LinkedList<>();
            if(askSplited[1].charAt(0)=='-'){
                for(StringBuilder sb : inputs_0){
                    inputs_1.add(new StringBuilder(sb.append("b ")));
                    sb.replace(sb.length()-2, sb.length(),"");
                    inputs_1.add(new StringBuilder(sb.append("f ")));
                }
            }
            else{
                for(StringBuilder sb : inputs_0){
                    inputs_1.add(new StringBuilder(sb.append(askSplited[1].charAt(0))+" "));
                }
            }

            LinkedList<StringBuilder> inputs_2 = new LinkedList<>();
            if(askSplited[2].charAt(0)=='-'){
                for(StringBuilder sb : inputs_1){
                    inputs_2.add(new StringBuilder(sb.append("j ")));
                    sb.replace(sb.length()-2, sb.length(),"");
                    inputs_2.add(new StringBuilder(sb.append("s ")));
                }
            }
            else{
                for(StringBuilder sb : inputs_1){
                    inputs_2.add(new StringBuilder(sb.append(askSplited[2].charAt(0))+" "));
                }
            }

            LinkedList<StringBuilder> inputs_3 = new LinkedList<>();
            if(askSplited[3].charAt(0)=='-'){
                for(StringBuilder sb : inputs_2){
                    inputs_3.add(new StringBuilder(sb.append("c ").toString()));
                    sb.replace(sb.length()-2, sb.length(),"");
                    inputs_3.add(new StringBuilder(sb.append("p ").toString()));
                }
            }
            else{
                for(StringBuilder sb : inputs_2){
                    inputs_3.add(new StringBuilder(sb.append(askSplited[3].charAt(0))));
                }
            }

            int cnt=0;
            for(StringBuilder s : inputs_3){
                int key = converter(s.toString());

                for(int i=moreScore; i<10001; i++){
                    cnt+=board[key][i];
                }
            }
            answer[index++] = cnt;
        }

        for(int i : answer){
           System.out.println(i);
        }

        /*
        ava	backend	junior	pizza	150
python	frontend	senior	chicken	210
python	frontend	senior	chicken	150
cpp	backend	senior	pizza	260
java	backend	junior	chicken	80
python	backend	senior	chicken	50
         */

//        System.out.println(board[converter("j b j p")][150]);
    }

    static int converter(String string) {
        String[] splited = string.split(" ");

        StringBuilder sb = new StringBuilder();

        if (splited[1].charAt(0) == 'b') {
            sb.append(0);
        } else {
            sb.append(1);
        }

        if (splited[2].charAt(0) == 'j') {
            sb.append(0);
        } else {
            sb.append(1);
        }

        if (splited[3].charAt(0) == 'c') {
            sb.append(0);
        } else {
            sb.append(1);
        }

        if (splited[0].charAt(0) == 'j') {
            return Integer.parseInt(sb.toString(), 2) ;
        } else if (splited[0].charAt(0) == 'c') {
            return Integer.parseInt(sb.toString(), 2) +8 ;
        } else if (splited[0].charAt(0) == 'p') {
            return Integer.parseInt(sb.toString(), 2) +16;
        }

        return 0;
    }
}
