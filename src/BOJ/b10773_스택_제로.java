package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10773_스택_제로 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){ stack.pop(); }
            else{ stack.push(number); }
        }
        int sum =0;
        for(int s : stack){
            sum += s;
        }
        System.out.print(sum);
    }
}
