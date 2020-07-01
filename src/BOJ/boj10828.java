package BOJ;

import java.io.*;

public class boj10828 {
    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         String[] commands = new String[n];
         for(int i=0; i<n; i++){
             commands[i] = br.readLine();
         }

         Stack_10828 stack = new Stack_10828();
         
         for(String command : commands){
             String[] splited = command.split(" ");

             switch (splited[0]){
                 case "push":
                     stack.push(Integer.parseInt(splited[1]));
                     break;
                 case "top":
                     System.out.println(stack.top());
                     break;
                 case "size":
                     System.out.println(stack.getSize());
                     break;
                 case "pop":
                     System.out.println(stack.pop());
                     break;
                 case "empty":
                     if(stack.empty()) System.out.println("1");
                     else System.out.println("0");
                     break;
             }
         }

    }
}

class Node_10828 {
    int data =0;
    Node_10828 prev = null;

    public Node_10828(int i){
        data = i;
    }
}

class Stack_10828 {
    int size =0;
    Node_10828 topNode = null;

    void push(int i){
        if(topNode == null){
            topNode = new Node_10828(i);
        }
        else{
            Node_10828 now = new Node_10828(i);
            now.prev = topNode;
            this.topNode = now;
        }

        size++;
    }

    int top(){
        if(size == 0)
            return -1;
        return topNode.data;
    }

    int pop(){
        if(size ==0){
            return -1;
        }
        else{
            Node_10828 top = topNode;
            this.topNode = topNode.prev;
            size--;
            return top.data;
        }
    }

    int getSize(){
        return size;
    }

    boolean empty(){
        return size==0;
    }
}