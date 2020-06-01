package Programmers_AlgorithmTest.LEVEL2;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        return answer = nums.length / 2 >= set.size() ? set.size() : nums.length/2;
    }
}