package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2914_구현_저작권 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AI = br.readLine().split(" ");
        int A = Integer.parseInt(AI[0]);
        int I = Integer.parseInt(AI[1]);

        System.out.println(A*(I-1)+1);
    }
}

class b10886_구현_notCuteOrCute{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] votes = new int[2];

        for(int i=0; i<n; i++){
            votes[Integer.parseInt(br.readLine())]++;
        }

        if(votes[0] < votes[1]){
            System.out.println("Junhee is cute!");
        }else{
            System.out.println("Junhee is not cute!");
        }
    }
}

class b2752_구현_세수정렬{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];

        String[] nums = br.readLine().split(" ");

        for(int i=0; i<3; i++){
            int n = Integer.parseInt(nums[i]);

            arr[i] = n;
        }

        Arrays.sort(arr);

        for(int i : arr){
            System.out.print(i+ " ");
        }
    }
}