package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class b10815_숫자카드{
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(Integer.parseInt(nums[i]), true);
        }

        int n_ = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        nums = br.readLine().split(" ");
        for(int i=0; i<n_; i++){

            if(map.containsKey(Integer.parseInt(nums[i]))){
                sb.append("1 ");
            }

            else{
                sb.append("0 ");
            }
        }

        System.out.print(sb);
    }
}
