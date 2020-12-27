package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b14889_백트래킹_스타트와링크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arry = new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arry[i][j] = Integer.parseInt(line[j]);
            }
        }

        isUsed= new boolean[n];

        setA = new int[n/2];
        setB = new int[n/2];

        func(0,0);
        System.out.print(min);
    }

    static int n;
    static boolean[] isUsed;
    static int[][] arry;
    static int min = 100;
    static int[] setA;
    static int[] setB;

    static int teamA =0;
    static int teamB =0;

    static void func(int index , int num){
        if(index == n/2){
            int j=0;
            for(int i=0; i<n; i++){
                if(isUsed[i] == false){
                    setB[j++] = i;
                }
            }

            teamA = getTeamWork(setA);
            teamB = getTeamWork(setB);

            int dif = Math.abs(teamA-teamB);
            if(dif<min) min = dif;

            return;
        }

        for(int i=0; i<n; i++){
            if(isUsed[i]==true) continue;
            if(num>i) continue;

            setA[index] = i;
            isUsed[i] = true;
            func(index+1, i);
            isUsed[i] = false;
        }
    }

    static int getTeamWork(int[] set){
        int sum =0;
        for(int i=0; i< set.length-1; i++){
            for(int j = i+1; j<set.length; j++){
                sum+=teamWork(set, i,j);
            }
        }
        return sum;
    }
    static int teamWork(int[]set, int a, int b){
        int ability = arry[set[a]][set[b]] + arry[set[b]][set[a]];
        return ability;
    }
}


