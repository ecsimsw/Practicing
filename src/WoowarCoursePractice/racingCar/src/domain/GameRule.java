package WoowarCoursePractice.racingCar.src.domain;

public class GameRule {
    private static final int CONDITION_VALUE_TO_MOVE = 4;

    private GameRule(){}

    public static boolean isConditionToGo(int value){
        return value >= CONDITION_VALUE_TO_MOVE;
    }
}
