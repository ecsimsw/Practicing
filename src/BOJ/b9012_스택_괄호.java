package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012_스택_괄호 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        boolean isFinish= false;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(char c : str.toCharArray()){
                if(c == '('){ stack.push(c); }
                else if(c == ')'){
                    if (stack.size() > 0) stack.pop();
                    else { isFinish=true; break;}
                }
            }

            if(!isFinish) {
                if (stack.size() == 0){
                    sb.append("YES\n");
                }
                else { sb.append("NO\n"); }
            }
            else{ sb.append("NO\n"); }

            while(!stack.isEmpty()){
                stack.pop();
            }
            isFinish=false;
        }

        System.out.print(sb);
    }
}
