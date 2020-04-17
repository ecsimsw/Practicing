package Programmers_AlgorithmTest.Stack_Queue;

import java.sql.Struct;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
public class 다리를건너는트럭 {
    public static void main(String[] args) {
        System.out.println(Solution());
    }

    static int Solution(){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};


        Queue<Truck> onBridge = new LinkedList<Truck>();

        int onBridgeWeight =0;
        int answer =0;
        int indexTruck=0;

        while(true){

            System.out.println(onBridgeWeight+"  "+answer);
            answer++;

            for(Truck t : onBridge){
                t.life++;
                if(t.life>bridge_length-1){
                    onBridgeWeight -= t.weight;
                    onBridge.poll();
                }
            }

            if(indexTruck < truck_weights.length){
                if(onBridgeWeight + truck_weights[indexTruck] < weight) {
                    onBridge.add(new Truck(truck_weights[indexTruck]));
                    onBridgeWeight+= truck_weights[indexTruck];
                    indexTruck++;
                }
            }
            else{
                if(onBridge.isEmpty()){
                    return answer;
                }
            }
        }
    }
}

class Truck{
    int weight;
    public int life=0;

    Truck(int w){
        this.weight = w;
    }
}

/*
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 */