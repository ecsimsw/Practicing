package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b1021_큐_회전하는큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        list = new LinkedList<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }

        int point = 0;
        int move =0;

        for(int search =0; search<n; search++){
            int next = findX(arr[search]);
            int dif;
            if(next < point ){
                dif = Math.min(point-next, list.size()-point+next);
            }
            else{
                dif = Math.min(next-point, list.size()-next+point);
            }

            move+= dif;
            list.remove(next);

            point = next;
            if(list.size() == point){
                point =0;
            }
        }

        System.out.println(move);
    }

    static LinkedList<Integer> list;

    static int findX(int i){
        for(int index=0; index<list.size(); index++ ){
            if(list.get(index) == i){
                return index;
            }
        }
        return 0;
    }

}
