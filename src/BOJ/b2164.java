package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class b2164{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=n; i>=1; i--){
            list.add(i);
        }

        while(list.size()>1){
            list.removeLast();
            int temp = list.pollLast();
            list.addFirst(temp);
        }
        System.out.print(list.poll());
    }
}
