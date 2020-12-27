package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class b2493_stack{
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n];

        String[] numbers = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            tower[i] = Integer.parseInt(numbers[i]);
        }

        Stack<Integer> stack_h = new Stack<>();
        Stack<Integer> stack_i = new Stack<>();

        int[] ans = new int[n];

        for(int i = n-1; i>-1; i--){
            if(stack_h.isEmpty()) {
                stack_h.push(tower[i]);
                stack_i.push(i);
                continue;
            }
            while(stack_h.peek() < tower[i]){
                ans[stack_i.pop()] = i+1;
                stack_h.pop();
                if(stack_h.isEmpty())break;
            }
            stack_h.push(tower[i]);
            stack_i.push(i);
        }

        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
