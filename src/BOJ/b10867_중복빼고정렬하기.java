package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class b10867_중복빼고정렬하기{
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num;
        String[] numStr = br.readLine().split(" ");
        boolean[] arr = new boolean[2002];

        for(int i=0; i<n; i++){
            num = Integer.parseInt(numStr[i]);
            arr[num+1001] = true;
        }

        for(int i=0; i<2002; i++){
            if(arr[i] == true){
                System.out.print(i-1001 + " ");
            }
        }
    }
}
