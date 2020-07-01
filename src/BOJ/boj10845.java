package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = br.readLine();
        }

        Queue_10845 queue = new Queue_10845();

        for (String command : commands) {
            String[] splited = command.split(" ");

            switch (splited[0]) {
                case "push":
                    queue.push(Integer.parseInt(splited[1]));
                    break;
                case "size":
                    System.out.println(queue.getSize());
                    break;
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "empty":
                    if (queue.empty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
            }
        }
    }
}

class Node_10845{
    int data;
    Node_10845 nextNode = null;

    public Node_10845(int i){
        data= i;
    }
}


class Queue_10845 {
    int size= 0;
    Node_10845 bottomNode =null;
    Node_10845 topNode = null;

    void push(int i){
        if(size == 0){
             bottomNode = new Node_10845(i);
             topNode = bottomNode;
        }
        else{
            Node_10845 node = new Node_10845(i);
            topNode.nextNode = node;
            topNode = topNode.nextNode;
        }
        size++;
    }

    int pop(){
        if(size ==0) return -1;
        else {
            Node_10845 bottom = bottomNode;
            bottomNode = bottomNode.nextNode;
            size--;
            return bottom.data;
        }
    }

    int getSize(){
        return size;
    }

    boolean empty(){
        return size == 0;
    }

    int front(){
        if(size == 0) return -1;
        return bottomNode.data;
    }
    int back(){
        if(size==0) return -1;
        return topNode.data;
    }
}