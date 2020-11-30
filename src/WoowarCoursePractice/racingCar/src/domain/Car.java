package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.utils.InputValidator;
import WoowarCoursePractice.racingCar.src.utils.RandomUtils;
import WoowarCoursePractice.racingCar.src.view.InputView;

public class Car implements Comparable<Car>{
    private static final int MAX_MOVE = 9;
    private static final int MIN_MOVE = 0;
    private static final int CONDITION_VALUE_TO_MOVE = 4;

    public final String name;
    public int position;

    public Car(String name) throws IllegalArgumentException{
        InputValidator.checkValidCarName(name);

        this.name = name;
        this.position = 0;
    }

    public void tryMove(){
        int value =  RandomUtils.nextInt(MIN_MOVE, MAX_MOVE);

        if(this.isConditionToGo(value)){
            position++;
        }
    }

    private boolean isConditionToGo(int value){
        return value >= CONDITION_VALUE_TO_MOVE;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }
}
