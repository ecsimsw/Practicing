package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class b10989_수정렬하기3{
    static public void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        int integer =0;
        int[] arr = new int[10001];
        for(int i=0; i<n; i++){
            integer = Integer.parseInt(br.readLine());
            arr[integer]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<10001; i++){
            if(arr[i] ==0) continue;
            for(int count =0; count<arr[i]; count++) {
                sb.append(i+" \n");
            }
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.print(sb);
    }
}

class b10989_수정렬하기3_priorityQueue {
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        System.out.println(sb);
    }
}

class b10989_수정렬하기3_ArraysSort {
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        int integer=0;
        for(int i=0; i<n; i++){
            integer = Integer.parseInt(br.readLine());
            arr[i] = integer;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int j : arr){
            sb.append(j+"\n");
        }

        System.out.println(sb);
    }
}

