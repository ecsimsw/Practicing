package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1966_큐_프린터큐 {
    static public void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 6;
        int index =0;

        int[] nums = new int[]{1,1,9,1,1,1};
        int[] p = new int[]{5,0,0,0,0,0,0,0,1};
        int myIndex =index;
        int max = 9;
        int cnt =0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i : nums){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            int peek = queue.poll();

            if(peek == max){
                if(myIndex == 0) {break;}
                else{
                    myIndex--;
                    if(myIndex==0){
                        myIndex = queue.size()-1;
                    }
                    cnt++;
                    nums[max]--;
                    max = findMax(nums);
                }
            }
            else{
                queue.offer(peek);
            }
        }

        System.out.print(cnt);
    }

    static int findMax(int[] nums){
        for(int i=9; i>0; i--){
            if(nums[i] != 0) return i;
        }
        return 0;
    }
}
