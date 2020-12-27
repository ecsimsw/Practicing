package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b11279_우선순위큐_최대힙 {
    private static PriorityQueue<Integer> priorityQueue;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            execute(Integer.parseInt(br.readLine()));
        }
        System.out.print(stringBuilder.toString());
    }

    private static void execute(int instruction) {
        if (instruction == 0) {
            printMaxValue();
            return;
        }
        priorityQueue.add(instruction);
    }

    private static void printMaxValue() {
        if (priorityQueue.size() == 0) {
            stringBuilder.append(0+"\n");
            return;
        }
        stringBuilder.append(priorityQueue.poll()+"\n");
    }
}
