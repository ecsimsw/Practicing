package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1074_재귀_Z {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        find_s = Integer.parseInt(str[1]);
        find_g = Integer.parseInt(str[2]);

        z((int) Math.pow(2,N),0,0);

        System.out.print(order-1);
    }

    private static int order = 0;
    private static boolean isFound = false;
    private static int find_s;
    private static int find_g;

    private static void z(int N, int s, int g){
        if(isFound){
            return;
        }

        if(N==1){
            checkIsFindIndex(s,g);
            order++;
            return;
        }

        if(!isInRange(N, s, g)){
            order += N*N;
            return;
        }

        z(N/2, s, g);
        z(N/2, s, g+N/2);
        z(N/2, s+N/2, g);
        z(N/2, s+N/2, g+N/2);
    }

    private static void checkIsFindIndex(int s, int g){
        if(s == find_s && g == find_g){
            isFound = true;
        }
    }

    private static boolean isInRange(int N, int s, int g){
        if(s<= find_s && g<= find_g && s+N > find_s && g+N >= find_g){
            return true;
        }
        return false;
    }
}
