package Programmers_AlgorithmTest.Stack_Queue;

import java.nio.charset.IllegalCharsetNameException;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를건너는트럭 {
    static public void main(String[] args){
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        Solution otherCode = new Solution();
        System.out.println(otherCode.solution(bridge_length, weight, truck_weights));

    /*
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        Queue<Truck> onBridge = new LinkedList<>();

        int onBridgeWeight = 0;
        int index=0;
        int answer=0;

        while(true){
            System.out.println("a :"+answer);
            if(onBridge.size() !=0)
                System.out.println("w :" + onBridge.peek().hashCode()+ "l : "+onBridge.peek().life);

            if(index < truck_weights.length){
                if(onBridgeWeight + truck_weights[index] <= weight){
                    System.out.println("offer");
                    onBridge.offer(new Truck(truck_weights[index]));
                    onBridgeWeight += truck_weights[index];
                    index++;
                }
            }
            else{ if(onBridge.isEmpty()){ break; } }

            for(Truck t : onBridge){ t.life++; }

            if(onBridge.peek().life == bridge_length){
                onBridgeWeight-=onBridge.peek().weight;
                onBridge.poll();
            }
            answer++;
        }

        System.out.println(answer);

         */
    }
}

class Truck{
    int life=0;
    int weight;

    public Truck(int w){
        this.weight = w;
    }
}

class Solution {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) { waitQ.offer(new Truck(t)); }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }

            for (Truck t : moveQ) { t.moving();}

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }


        }

        return answer;
    }
}
