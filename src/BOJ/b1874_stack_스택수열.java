package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class b1874_stack_스택수열 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        int n = 1;

        queue.offer(4);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        queue.offer(7);
        queue.offer(5);
        queue.offer(2);
        queue.offer(1);

        boolean isAble = true;
        while(true){
            if(stack.isEmpty()) {
                System.out.println("push "+n);
                stack.push(n);
                n++;
            }

            if(stack.peek() == queue.peek()){
                System.out.println("pop "+stack.peek());
                stack.pop();
                queue.poll();
                n++;
            }

            else if(stack.peek() < queue.peek()){
                System.out.println("push "+n);
                stack.push(n);
                n++;
            }

            else if(stack.peek() > queue.peek()){
                isAble =false;
                break;
            }

            if(n > 8) break;
        }
    }
}