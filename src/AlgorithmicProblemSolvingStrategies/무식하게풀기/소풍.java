package AlgorithmicProblemSolvingStrategies.무식하게풀기;

/*
친구 관계가 주어지면 해당 관계로만 이루어진 방법의 가짓수

총 4명, 01 12 13 23이라면

        01 23 / 01 23
 */

import java.util.*;
import java.math.*;

public class 소풍 {

    static public void main(String[] args) {
        int student = 4;
        int pare = 6;
        int[] friends = new int[] {0,1,1,2,2,3,3,0,0,2,1,3};
        // 01 23
        boolean[][] friendsMap = new boolean[pare][pare];

        for(int i=0; i<pare; i++){
            int min = Math.min(friends[i*2], friends[i*2+1]);
            int max = Math.max(friends[i*2], friends[i*2+1]);
            friendsMap[min][max] = true;
        }

        picnic(student, friendsMap, 0);

        System.out.print(answer);

    }

    static public int answer =0;
    static LinkedList<Integer> used = new LinkedList<>();
    static public boolean picnic(int student, boolean[][] map, int last){

        if(used.size()== student){
            return true;
        }

        for(int i=last; i<student-1; i++){
            for(int j=i+1; j<student; j++){
                if(used.contains(i) || used.contains(j)) {
                    continue;
                }
                else{
                    if(map[i][j] == true){
                        used.add(i);
                        used.add(j);
                        last = i;
                        if(picnic(student, map, last)) {
                            for(int u :used){
                                System.out.print(u);
                            }
                            System.out.println();
                            answer++;
                        }
                        used.pollLast();
                        used.pollLast();
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
