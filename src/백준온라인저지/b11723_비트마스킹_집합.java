package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class b11723_비트마스킹_집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] arr= new boolean[21];

        for(int i=0; i<n; i++){
            String[] ins = br.readLine().split(" ");

            String op = ins[0];

            if(op.equals("add")){
                int num = Integer.parseInt(ins[1]);
                arr[num] = true;
            }

            if(op.equals("remove")){
                int num = Integer.parseInt(ins[1]);
                arr[num] = false;
            }

            if(op.equals("check")){
                int num = Integer.parseInt(ins[1]);
                if(arr[num] == true){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }

            if(op.equals("toggle")) {
                int num = Integer.parseInt(ins[1]);
                arr[num] = !arr[num];
            }

            if(op.equals("all")){
                Arrays.fill(arr, true);
            }

            if(op.equals("empty")){
                Arrays.fill(arr, false);
            }
        }

        System.out.println(sb.toString());
    }
}
