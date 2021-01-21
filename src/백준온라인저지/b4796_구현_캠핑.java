package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b4796_구현_캠핑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> Ls = new LinkedList<>();
        LinkedList<Integer> Ps = new LinkedList<>();
        LinkedList<Integer> Vs = new LinkedList<>();

        while(true){
            String[] line = br.readLine().split(" ");
            if(Integer.parseInt(line[0]) == 0){
                break;
            }
            Ls.offer(Integer.parseInt(line[0]));
            Ps.offer(Integer.parseInt(line[1]));
            Vs.offer(Integer.parseInt(line[2]));
        }

        int num =1;
        while(!Ls.isEmpty()){
            int result = func(Ls.poll(), Ps.poll(), Vs.poll());
            System.out.println("Case "+ num++ + ": "+ result);
        }
    }

    private static int func(int l, int p, int v){
        int ans =0;

        int div = v / p;
        int mod = v % p;

        ans = div * l + Math.min(mod, l);
        return ans;
    }
}
