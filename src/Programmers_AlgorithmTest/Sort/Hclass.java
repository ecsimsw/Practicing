package Programmers_AlgorithmTest.Sort;

import java.util.Arrays;

public class Hclass {
    public static void main(String[] args){
        int[] citations = new int[]{0,0,1,1,4,6,6,9,2,3,10};
        System.out.print(solution(citations));
    }

    static int solution(int[] citations) {
        int answer=0;
        Arrays.sort(citations);

        int index_nextNumber=1;
        int index_nowNumber = citations[0];
        int h = citations[index_nowNumber];
        int moreThanH=0;

        while(index_nowNumber < citations.length){
            for(int i = index_nowNumber; i< citations.length; i++){
                if(index_nowNumber<citations[i]){
                    index_nextNumber= i;
                    break;
                }
            }
            if(index_nextNumber < citations.length){
                if(h>=citations[index_nextNumber]){
                    index_nowNumber = index_nextNumber;

                    for(int i = index_nowNumber; i< citations.length; i++){
                        if(index_nowNumber<citations[i]){
                            index_nextNumber= i;
                            break;
                        }
                    }
                }
            }

            if(h == citations[index_nowNumber]) moreThanH = citations.length - index_nowNumber;
            else if(h > citations[index_nowNumber]) moreThanH = citations.length - index_nowNumber-1;

            System.out.println("h : "+h + "  index : "+index_nowNumber + "  moreThanH  : "+moreThanH);

            if(h == moreThanH) break;
            else if(h < moreThanH){ h++;}
            else if(h> moreThanH){h--; break;}
        }

        answer= h;
        return answer;
    }
}

/*
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

제한사항
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 */