package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2511_구현_카드놀이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs1 = br.readLine().split(" ");
        String[] strs2 = br.readLine().split(" ");

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        int a_cnt =0;
        int b_cnt =0;

        int a_sum =0;
        int b_sum =0;

        for(int i=0; i<10; i++){
            arr1[i] = Integer.parseInt(strs1[i]);
            arr2[i] = Integer.parseInt(strs2[i]);


            if(arr1[i] > arr2[i]) {
                a_sum+=3;
                a_cnt++;
            }
            else if(arr1[i] < arr2[i]){
                b_sum+=3;
                b_cnt++;
            }
            else{
                a_sum++;
                b_sum++;
            }
        }

        String ans = "D";

        if(a_cnt == b_cnt){
            for(int i =9; i>-1; i--){
                if(arr1[i] > arr2[i]){
                    ans = "A";
                    break;
                }
                else if(arr1[i] < arr2[i]){
                    ans = "B";
                    break;
                }
            }
        }
        else{
            ans = a_cnt>b_cnt ? "A" : "B";
        }

        System.out.println(a_sum + " "+ b_sum);
        System.out.println(ans);
    }
}
