package 프로그래머스.LEVEL2;

import java.util.LinkedList;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        int pre = arr[0];

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(pre);

        for(int i=1; i<arr.length; i++){
            if(pre != arr[i]){
                pre= arr[i];
                linkedList.add(pre);
            }
        }

        int[] answer = new int[linkedList.size()];

        int index=0;
        for(int i : linkedList){
            answer[index] =i;
        }

        return answer;
    }
}
