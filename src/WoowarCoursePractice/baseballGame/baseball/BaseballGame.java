package WoowarCoursePractice.baseballGame.baseball;

import WoowarCoursePractice.baseballGame.utils.Numbers;
import WoowarCoursePractice.baseballGame.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public BaseballGame(){

    }

    public void play(){
        setTargetNumber();
    }

    private void setTargetNumber(){
        List<Integer> targetList = new ArrayList<>();

        while(targetList.size() < Numbers.LEN){
            int rand = getRandWithoutDuplicate(targetList);
            targetList.add(rand);
        }
    }

    private int getRandWithoutDuplicate(List list){
        int rand;

        do{
            rand = RandomUtils.nextInt(Numbers.MIN, Numbers.MAX);
        }while(list.contains(rand));

        return rand;
    }
}

