package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class b1874_stack_스택수열 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        boolean isAble = true;

        int number =1;
        while(true){
            if(stack.isEmpty()) {
                sb.append("+\n");
                stack.push(number);
                number++;
            }

            if(stack.peek() == queue.peek()){
                sb.append("-\n");
                stack.pop();
                queue.poll();
            }
            else if(stack.peek() < queue.peek()){
                sb.append("+\n");
                stack.push(number);
                number++;
            }
            else if(stack.peek() > queue.peek()){
                isAble =false;
                break;
            }

            if(queue.isEmpty()) break;
        }
        sb.delete(sb.length()-1, sb.length());
        if(isAble) System.out.print(sb);
        else System.out.print("NO");
    }
}

class b1874_stack_스택수열_배열 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        boolean isAble = true;

        int number =1;
        while(true){
            if(stack.isEmpty()) {
                sb.append("+\n");
                stack.push(number);
                number++;
            }

            if(stack.peek() == queue.peek()){
                sb.append("-\n");
                stack.pop();
                queue.poll();
            }
            else if(stack.peek() < queue.peek()){
                sb.append("+\n");
                stack.push(number);
                number++;
            }
            else if(stack.peek() > queue.peek()){
                isAble =false;
                break;
            }

            if(queue.isEmpty()) break;
        }
        sb.delete(sb.length()-1, sb.length());
        if(isAble) System.out.print(sb);
        else System.out.print("NO");
    }
}