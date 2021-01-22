package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11655_문자열_ROT13 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] chars = br.readLine().split("");

        StringBuilder sb= new StringBuilder();

        for(String c : chars){
            char c1 = c.charAt(0);
            if(c1 >= 'A' && c1 <= 'Z'){
                sb.append((char)((((c1+13) % 'A')%26) + 'A'));
                continue;
            }

            if(c1 >= 'a' && c1 <= 'z'){
                sb.append((char)((((c1+13) % 'a')%26) + 'a'));
                continue;
            }

            sb.append(c);
        }

        System.out.print(sb.toString());
    }
}
