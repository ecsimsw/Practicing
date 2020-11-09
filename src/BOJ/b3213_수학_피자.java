package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class b3213_수학_피자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        int cnt_1= 0;
        int cnt_2= 0;
        int cnt_3= 0;

        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(str.equals("1/4")){ cnt_1++; }
            if(str.equals("1/2")){ cnt_2++; }
            if(str.equals("3/4")){ cnt_3++; }
        }

        int total_cnt =0;

        // pair 1 3
        if(cnt_1 > cnt_3){
            cnt_1 = cnt_1 - cnt_3;
            total_cnt += cnt_3;
        }
        else{
            total_cnt += cnt_3;
            cnt_1=0;
        }

        // pair 2
        int pair = cnt_2/2;
        cnt_2 = cnt_2 %2;
        total_cnt += pair;

        // pair 2 1

        if(cnt_2 == 1){
            if(cnt_1 >= 2){
                total_cnt+=1;
                cnt_1 -= 2;
            }
            else if(cnt_1 >=1 ){
                total_cnt+=1;
                cnt_1 -= 1;
            }
            else{
                total_cnt+=1;
            }
        }

        // pair 4
        pair = cnt_1/4;
        total_cnt += pair;
        if(cnt_1%4 !=0) total_cnt+=1;

        System.out.println(total_cnt);
    }
}


/* 시간 초과

public class b3213_수학_피자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(str.equals("1/4")){ list.add(1); }
            if(str.equals("1/2")){ list.add(2); }
            if(str.equals("3/4")){ list.add(3); }
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<list.size(); i++){
            int now = list.get(i);

            for(int j=0; j<i; j++){
                int pre = list.get(j);
                if(pre >= 4) continue;
                if(pre + now <= 4 ){
                    list.set(j, pre+now);
                    list.set(i, 5); // useless
                    break;
                }
            }
        }

        int cnt =0;
        for(int r : list){ if(r<=4) cnt++; }

        System.out.println(cnt);
    }
}

 */