package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b4949_스택_균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> stack;
        String line;

        while (true) {
            line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            stack = new Stack<>();

            boolean isBalanced = true;
            for (String s : line.split("")) {
                if (s.equals("(")) {
                    stack.push("(");
                }

                if (s.equals(")")) {
                    if (stack.isEmpty() || stack.pop().equals("[")) {
                        isBalanced = false;
                        break;
                    }
                }

                if (s.equals("[")) {
                    stack.push("[");
                }

                if (s.equals("]")) {
                    if (stack.isEmpty() || stack.pop().equals("(")) {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (isBalanced == false || !stack.isEmpty()) {
                sb.append("no\n");
                continue;
            }

            sb.append("yes\n");
        }

        System.out.print(sb.toString());
    }
}
