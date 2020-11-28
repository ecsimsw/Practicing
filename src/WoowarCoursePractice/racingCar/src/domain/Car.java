package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.utils.RandomUtils;

public class Car {
    private static final int MAX_MOVE = 9;
    private static final int MIN_MOVE = 0;

    private final String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void tryMove(){
        int value =  RandomUtils.nextInt(MIN_MOVE, MAX_MOVE);

        if(GameRule.isConditionToGo(value)){
            position++;
        }
    }
}
