package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class b2751_정렬_수정렬하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000001];

        int num;

        for(int i =0; i<n; i++){
            num = Integer.parseInt(br.readLine());
            check[num] = true;
        }


        Long time = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<1000001; j++){
            if(check[j]) sb.append(j+"\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.print(sb);

        System.out.println(System.currentTimeMillis()-time);
    }
}

class b2751_정렬_수정렬하기2_linkedList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        int num;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        //Long time = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();

        Collections.sort(list);
        for (int j : list) {
            sb.append(j + "\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.print(sb);


        //System.out.println(System.currentTimeMillis()-time);
    }
}