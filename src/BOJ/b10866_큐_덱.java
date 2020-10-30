package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b10866_큐_덱 {
    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] lines = new String[n];

        for(int i=0; i<n; i++){
            lines[i] = br.readLine();
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for(String line : lines){
            String instruction = line.split(" ")[0];
            int value=0;

            switch (instruction){
                case "push_front":
                    value = Integer.parseInt(line.split(" ")[1]);
                    queue.offerFirst(value);
                    break;
                case "push_back":
                    value = Integer.parseInt(line.split(" ")[1]);
                    queue.offerLast(value);
                    break;
                case "pop_front":
                    System.out.println(queue.peekFirst() != null ? queue.peekFirst() : -1);
                    queue.pollFirst();
                    break;
                case "pop_back":
                    System.out.println(queue.peekLast() != null ? queue.peekLast() : -1);
                    queue.pollLast();
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() == true ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.peekFirst() != null ? queue.peekFirst() : -1);
                    break;
                case "back":
                    System.out.println(queue.peekFirst() != null ? queue.peekLast() : -1);
                    break;
            }
        }
    }
}
