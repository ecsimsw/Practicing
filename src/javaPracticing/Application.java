package javaPracticing;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application {
    public static void main(String[] args){
        Queue pq = new PriorityQueue();

        pq.offer(1);
        pq.offer(2);
        pq.offer(6);
        pq.offer(4);

        for(Object obj : pq){
            System.out.print(obj+"  ");
        }
        System.out.println();

        int[] arr = new int[4]{};
        arr.clone();
        Arrays.copyOf(arr,arr.length);
    }
}
