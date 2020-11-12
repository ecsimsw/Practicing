package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class b2309_그리디_일곱난쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        boolean[] isThere = new boolean[101];

        for(int i=0; i<9; i++){
            nums[i] = Integer.parseInt(br.readLine());
            isThere[nums[i]] = true;
        }

        int sum=0;
        for(int i: nums) sum+=i;
        int dif = sum-100;
        int[] notDwarf = new int[2];

        for(int i =0; i<9; i++){
            if(dif == 2*nums[i]) continue;
            if(isThere[dif-nums[i]]) {
                notDwarf[0] = nums[i];
                notDwarf[1] = dif-nums[i];
                break;
            }
        }
        int[] dwarf = new int[7];
        int index=0;
        for(int i=0; i<9; i++){
            if(nums[i]== notDwarf[0] || nums[i] == notDwarf[1]){
                continue;
            }
            dwarf[index++]= nums[i];
        }

        Arrays.sort(dwarf);
        for(int i : dwarf) System.out.println(i);

    }
}
