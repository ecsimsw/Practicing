package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b6064_구현_카일달력 {
    static public void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][4];

        for(int i =0; i<n; i++){
            String[] line = br.readLine().split(" ");

            for(int j =0; j<4; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int loop=0; loop<n; loop++){
            int M = arr[loop][0];
            int N = arr[loop][1];

            int x = arr[loop][2];
            int y = arr[loop][3];

            int a = 1;
            int b = 1;

            int year =0;

            while(true){
                year++;
                if(a == x && b == y) break;

                if(a<M){ a++; }
                else{ a = 1; }

                if(b<N){ b++; }
                else{ b = 1; }

                if(a == 1 && b ==1){
                    year = -1;
                    break;
                }
            }
            sb.append(year+"\n");
        }
        System.out.print(sb);
    }
}
