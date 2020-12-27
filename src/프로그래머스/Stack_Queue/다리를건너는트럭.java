package 프로그래머스.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를건너는트럭 {
    static public void main(String[] args){
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
    }
}

class Truck{
    int life=0;
    int weight;

    public Truck(int w){
        this.weight = w;
    }
}