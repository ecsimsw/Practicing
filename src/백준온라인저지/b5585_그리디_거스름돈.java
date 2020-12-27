package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b5585_그리디_거스름돈{
    static public void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] moneyList = new int[]{500,100,50,10,5,1};

        int n = 1000-Integer.parseInt(br.readLine());

        int cnt=0;
        int moneyIndex= 0;
        while(true){
            if(n>=moneyList[moneyIndex]){
                cnt++;
                n-=moneyList[moneyIndex];
            }
            else{
                moneyIndex++;
            }
            if(n ==0) break;
        }
        System.out.print(cnt);
    }
}
