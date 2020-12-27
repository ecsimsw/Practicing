package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b12865_백트래킹_평범한배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        weight = Integer.parseInt(str[1]);

        bags = new Bag[n];

        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");

            int w = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);

            bags[i] = new Bag(w,v);
        }

        Arrays.sort(bags);

        func(weight, 0, 0);

        System.out.print(max);
    }

    static int n;
    static int weight;
    static Bag[] bags;
    static int max =0;

    static void func(int leftWeight, int index, int value){
        if(index>=n){
            if(value > max){max = value;}
            return;
        }

        if(bags[index].w > leftWeight){
            if(value > max){max = value;}
            return;
        }

        func(leftWeight-bags[index].w, index+1, value+bags[index].v);
        func(leftWeight, index+1, value);
    }
}
class Bag implements Comparable<Bag>{
    int w;
    int v;

    public Bag(int w, int v){
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Bag b) {
        if(this.w < b.w){
            return -1;
        }

        else if(this.w == b.w){
            if(this.v < b.v)
                return -1;
            else{
                return 1;
            }
        }
        else{
            return 1;
        }
    }
}