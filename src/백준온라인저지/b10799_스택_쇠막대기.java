package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class b10799_스택_쇠막대기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int answer = 0;

        LinkedList<String> stack = new LinkedList<>();

        String[] arr = line.split("");

        int index = 0;
        while (index < arr.length) {
            if (arr[index].equals("(")) {
                stack.push("(");
                index++;
                continue;
            }

            if (arr[index].equals(")")) {
                if (arr[index - 1].equals("(")) {
                    stack.pop();
                    answer += (stack.size());
                    index++;
                    continue;
                }
                stack.pop();
                answer++;
                index++;
                continue;
            }
        }
        System.out.print(answer);
    }
}


class b10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int answer = 0;

        LinkedList<Character> stack = new LinkedList<>();

        int point = 0;

        char prev = ' ';

        for (int index = 0; index < line.length(); index++) {
            if (prev == '(' && line.charAt(index) == ')') {
                point--;
                answer += point;
                prev = ')';
                continue;
            } else if (prev == ')' && line.charAt(index) == ')') {
                if (point > 0) {
                    answer++;
                    point--;
                    prev = ')';
                    continue;
                }
            } else if (line.charAt(index) == '(') {
                point++;
                prev = '(';
                continue;
            }

        }

        System.out.print(answer);
    }
}
