package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1202_탐욕법_보석도둑 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");

        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);

        ArrayList<Jewelry> jewelries = new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] WP = br.readLine().split(" ");
            jewelries.add(new Jewelry(Integer.parseInt(WP[0]), Integer.parseInt(WP[1])));
        }

        ArrayList<Integer> bags = new ArrayList<>();
        for(int i=0; i<k; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewelries);
        Collections.sort(bags);

        PriorityQueue<Integer> jewelryPriorityQueue
                = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0;
        int from =0;
        for(int bag : bags){
            for(int index=from; index<jewelries.size(); index++){
                if(jewelries.get(index).w <= bag){
                    jewelryPriorityQueue.add(jewelries.get(index).p);
                    from++;
                }else{
                    break;
                }
            }

            if(!jewelryPriorityQueue.isEmpty()){
                ans += jewelryPriorityQueue.poll();
            }
        }

        System.out.print(ans);
    }

    static class Jewelry implements Comparable<Jewelry>{

        int w;
        int p;

        public Jewelry(int w, int p){
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(Jewelry o) {
            if(this.w == o.w){
                return o.p - this.p;
            }

            return this.w - o.w;
        }

        @Override
        public String toString() {
            return "Jewelry{" +
                    "w=" + w +
                    ", p=" + p +
                    '}';
        }
    }
}
