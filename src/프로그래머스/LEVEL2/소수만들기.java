package 프로그래머스.LEVEL2;


/*
 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
 nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        int firstIndex =0;
        int middleIndex =1;
        int lastIndex =2;

        for(firstIndex=0; firstIndex<nums.length-2; firstIndex++){
            for(middleIndex=firstIndex+1; middleIndex<nums.length-1; middleIndex++){
                for(lastIndex = middleIndex+1; lastIndex<nums.length; lastIndex++){
                    if(isPrime(nums[firstIndex] + nums[middleIndex] + nums[lastIndex])== true) answer ++;
                }
            }
        }

        return answer;
    }
    boolean isPrime(int i){
        for(int j=2; j<i; j++){
            if(i%j ==0){
                return false;
            }
        }

        return true;
    }
}
