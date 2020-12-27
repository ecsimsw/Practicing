package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874_stack_스택수열 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] queue = new int[n];

        for(int i =0; i<n; i++){
            queue[i] = (Integer.parseInt(br.readLine()));
        }
        int q= 0;

        StringBuilder sb = new StringBuilder();
        int number = 1;
        boolean isAble = true;
        while(true){
            if(stack.isEmpty()) {
                if(number > n) { break;}
                sb.append("+\n");
                stack.push(number);
                number++;
            }

            if(stack.peek() == queue[q]){
                sb.append("-\n");
                stack.pop();
                q++;
            }

            else if(stack.peek() < queue[q]){
                sb.append("+\n");
                stack.push(number);
                number++;
            }

            else if(stack.peek() > queue[q]){
                isAble =false;
                break;
            }
        }
        sb.delete(sb.length()-1, sb.length());
        if(isAble) System.out.println(sb);
        else System.out.println("NO");
    }
}