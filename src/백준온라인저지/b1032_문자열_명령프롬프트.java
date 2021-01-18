package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1032_문자열_명령프롬프트 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] lines = new String[n][];

        for(int i=0; i<n; i++){
            String line  = br.readLine();
            lines[i] = line.split("");
        }

        int len = lines[0].length;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++){
            String character = lines[0][i];
            boolean isAllSame = true;
            for(int j=0; j<n; j++){
                if(!lines[j][i].equals(character)){
                    isAllSame = false;
                    break;
                }
            }

            if(isAllSame){
                sb.append(character);
            }else{
                sb.append("?");
            }
        }

        System.out.print(sb.toString());

    }
}
