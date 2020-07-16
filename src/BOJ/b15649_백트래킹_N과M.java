package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15649_백트래킹_N과M {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        range = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);

        permutation("",n, new boolean[range+1]);
    }

    static int n;
    static int range;
    static void permutation(String pre, int leftCount, boolean[] used){
        if(leftCount ==0){ System.out.println(pre); return;}

        for(int i=1; i<=range; i++){
            if(used[i] == true) continue;
            used[i] = true;
            permutation(pre+i+" ", leftCount-1, used);
            used[i] = false;
        }
    }
}
