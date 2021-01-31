package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2565_구현_전기줄 {
    static Line[] lines;
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        lines = new Line[n];

        for(int i =0; i<n; i++){
            String[] nums = br.readLine().split(" ");
            lines[i] = new Line(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }

        Arrays.sort(lines);

        int[] crossArr = new int[n];

        int subCnt =0;
        int crossedIndex=0;
        do{
            for(int i =0; i<n; i++){
                crossArr[i] = countCross(i);
            }
            for(int i = n-1; i>-1; i--){
                if(crossArr[i] > 0){
                    crossedIndex = i;
                    crossArr[crossedIndex] = 0;
                    lines[crossedIndex].start = 999;
                    lines[crossedIndex].end = 999;
                    subCnt ++;
                    break;
                }
            }
        }while(crossedIndex != 0);

        System.out.println(subCnt);
    }

    static int countCross(int index){
        int score=0;

        for(int i = index+1; i<n; i++){
            if(lines[index].end == 999){
                continue;
            }
            if(lines[index].end > lines[i].end){
                score++;
            }
        }

        return score;
    }

    static class Line implements Comparable<Line>{
        int start;
        int end;

        public Line(int s, int e){
            start =s;
            end =e;
        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }
}
