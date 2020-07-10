package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class b4949_Stack_괄호 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        List<String> strings = new LinkedList<>();

        while(true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            strings.add(str);
        }

        for(String str : strings) {

            Stack<String> stack = new Stack<>();

            for (String s : str.split("")) {
                switch (s) {
                    case "[":
                    case "(":
                        stack.push(s);
                        break;
                    case "]":
                        if (stack.empty()) {
                            stack.push(s);
                        } else {
                            if (stack.peek().equals("[")) stack.pop();
                            else stack.push(s);
                        }
                        break;
                    case ")":
                        if (stack.empty()) {
                            stack.push(s);
                        } else {
                            if (stack.peek().equals("(")) stack.pop();
                            else stack.push(s);
                        }
                        break;
                }
            }
            if (stack.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
