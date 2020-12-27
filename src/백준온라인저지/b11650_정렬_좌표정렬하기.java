package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b11650_정렬_좌표정렬하기 {
    static class Point implements Comparable{
        int x;
        int y;

        public Point(int a, int b){ x = a; y = b; }

        public int compareTo(Object o){
            if(o instanceof Point){
                Point temp = (Point)o;
                if(this.x < temp.x) return -1;
                else if(this.x ==temp.x){
                    if(this.y < temp.y) return -1;
                    else return 1;
                }
                else return 1;
            }
            else{ return 0;}
        }

        public String toString(){
            return x+" "+y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<Point>();

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            pq.offer(new Point(x,y));
        }

        while(!pq.isEmpty()){
            Point p = pq.poll();
            System.out.println(p.toString());
        }
    }
}

