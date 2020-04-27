package codingTest;

import java.util.*;

public class DevMaching_2020 {
    static public void main(String[] args){
        System.out.println(solution3(new int[]{3,7,2,8,6,4,5,1},3));

    }

    static public int solution1(String p, String s) {
        char[] pArray = p.toCharArray();
        char[] sArray = s.toCharArray();

        int pInt;
        int sInt;

        int bigger;
        int smaller;

        int answer=0;

        for(int index =0; index< pArray.length; index++){
            pInt = (int)pArray[index];
            sInt = (int)sArray[index];

            if(pInt > sInt){ bigger = pInt; smaller= sInt;}
            else{ bigger = sInt; smaller = pInt;}

            int change = (smaller+10 - bigger < bigger - smaller) ? smaller+10-bigger : bigger-smaller;

            answer+=change;
        }

        return answer;
    }

    static public int solution2(int[][] office, int r, int c, String[] move){
        int x = r;
        int y = c;
        int look = 0;
        //    0
        //  3   1
        //    2

        int boundary_x = office[0].length;
        int boundary_y = office.length;

        int answer =0;

        answer += office[x][y];
        office[x][y] =0;

        for(String moving : move){
            if(moving.equals("left")){
                look = (look == 0)? 3 : look-1;
            }
            else if(moving.equals("right")){
                look = (look == 3)? 0 : look+1;
            }

            else if(moving.equals("go")){
                switch (look){
                    case 0:
                        if( x-1 > -1)
                            if( office[x-1][y] != -1)
                                x--;
                        break;
                    case 1:
                        if(y+1 < boundary_y && office[x][y+1] != -1)
                            y++;
                        break;
                    case 2:
                        if(x+1 < boundary_x && office[x+1][y] != -1)
                            x++;
                        break;
                    case 3:
                        if(y-1 > -1)
                            if(office[x][y-1] != -1)
                                y--;
                        break;
                }


                answer += office[x][y];
                office[x][y] =0;

            }
        }

        return answer;
    }

    static public int solution3(int[] numbers, int K){
       int[] numbers_ = numbers.clone();

       Arrays.sort(numbers_);

       for(int i=0; i<numbers_.length-1; i++){
           if(numbers_[i+1]-numbers_[i] > K){
               return -1;
           }
       }

       return 0;
    }
}
