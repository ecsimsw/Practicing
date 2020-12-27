package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b6064_규칙_카잉달력 {
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][4];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");

            for(int j=0; j<4; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i=0; i<n; i++){
            int M = arr[i][0];
            int N = arr[i][1];
            int a = arr[i][2];
            int b = arr[i][3];

            int smaller, bigger;
            int smaller_dest, bigger_dest;

            if(M<=N){
                smaller = M; bigger = N;
                smaller_dest = a; bigger_dest = b;
            } else{
                smaller = N; bigger = M;
                smaller_dest = b; bigger_dest = a;
            }

            if(bigger_dest>bigger) return;

            int x = bigger % smaller, y =bigger_dest;

            int steps = y;
            int firstSmaller = x;
            int dif = bigger-smaller;

            x=firstSmaller;
            while(true){
                if(x == smaller_dest) break;
                if(x+dif> smaller){x= x+dif-smaller;}
                else{x+=dif;}
                if(x == firstSmaller) { steps = -1; break; }
                steps+=bigger;
            }
            sb.append(steps+"\n");
        }

        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
