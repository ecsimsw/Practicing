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

        while(!jobQ.isEmpty()){
            int complete = 0;

            Iterator<Job> iter = jobQ.iterator();
            while(iter.hasNext())
            {
                Job j = iter.next();
                j.progress += j.speed;
                if(j.progress >= 100){
                    complete++;
                    iter.remove();
                }
            }
            if(complete !=0) answerLL.add(complete);
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
