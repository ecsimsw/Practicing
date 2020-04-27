package Programmers_AlgorithmTest.Stack_Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    static public void main(String[] args)
    {
        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};
        solution(progresses,speeds);
    }

    static void solution(int[] progresses, int[] speeds){
        LinkedList<Job> jobQ = new LinkedList<>();

        for(int i=0; i< progresses.length; i++){
            jobQ.offer(new Job(progresses[i],speeds[i]));
        }

        LinkedList<Integer> answerLL = new LinkedList<>();

        int complete = 0;
        while(!jobQ.isEmpty()){
            // 하루 작업
            for(Job j : jobQ){
                j.progress += j.speed;
            }

            // 1번 작업이 완성 되었는지 확인해서, 처리된 이후 작업를 포함하여 완성 수을 한번에 배열에 저장
            if(jobQ.peek().progress>=100){
                complete++;
                answerLL.add(complete);
                complete =0;
                jobQ.poll();
            }
            // 1번 작업이 완성 안됐더라도, 이후 작업이 완성되면 큐에서 삭제하여 더 이상 작업하지 않도록 하고,
            // 대신 완성 수를 기록
            else{
                Iterator<Job> iter = jobQ.iterator();
                while(iter.hasNext())
                {
                    Job j = iter.next();
                    if(j.progress >=100){
                        complete++;
                        iter.remove();
                    }
                }
            }
        }

        int[] answer = new int[answerLL.size()];

        int i=0;
        for(int temp : answerLL){
            answer[i] = temp;
            i++;
            System.out.println(temp);
        }
    }
}

class Job{
    int progress;
    int speed;

    public Job(int p, int s){
        this.progress = p;
        this.speed = s;
    }
}

/*
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다.
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 */