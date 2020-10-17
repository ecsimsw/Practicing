package BOJ;

import java.io.*;
import java.util.LinkedList;

public class b18258_큐_큐2 {

    static public void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            String instruction = br.readLine();
            if(instruction.equals(""))break;
            Integer r = func(instruction);
            if(r != null) {
                sb.append(r+"\n");
            }
        }
        System.out.print(sb.toString());
    }

    static LinkedList<Integer> queue;

    static Integer func(String instruction){
        String[] ins = instruction.split(" ");

        switch (ins[0]){
            case "push":
                queue.add(Integer.parseInt(ins[1]));
                return null;

            case "pop":
                if(queue.isEmpty()){ return -1; }
                return queue.poll();

            case "size":
                return queue.size();

            case "empty":
                boolean r = queue.isEmpty();
                return r == true ? 1 : 0;

            case "front":
                if(queue.isEmpty()){return -1;}
                return queue.peek();

            case "back":
                if(queue.isEmpty()){return -1;}
                return queue.getLast();

            default:
                return null;
        }
    }
}
