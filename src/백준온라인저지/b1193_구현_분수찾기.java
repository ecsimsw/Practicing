package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1193_구현_분수찾기 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int index=0;

        while(true){
            if((index*index + index)/2 >= n){ break; }
            index++;
        }

        int now = (index*index + index)/2 - index;
        int dif = n - now;

        int s;
        int m;

        if(index%2 !=0 ){
            s = index;
            m = 1;

            for(int i=1; i<dif; i++){ s--;m++;
            }
        }else{
            s = 1;
            m = index;

            for(int i=1; i<dif; i++){ s++;m--;
            }
        }
        System.out.println(s+"/"+m);

    }
}
