package WoowarCoursePractice.racingCar.src.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameRule {
    private static final int CONDITION_VALUE_TO_MOVE = 4;

    private GameRule(){}

    public static boolean isConditionToGo(int value){
        return value >= CONDITION_VALUE_TO_MOVE;
    }

    public static List<Car> findWinner(List<Car> carList){
        int farthestPostion = findFarthestPositionWithStream(carList);
        return carList.stream().filter(car -> car.position == farthestPostion)
                .collect(Collectors.toList());
    }

    private static int findFarthestPositionWithStream(List<Car> carList){
        return carList.stream()
                .max(Comparator.comparingInt(car -> car.position))
                .get()
                .position;
    }

    private static int findFarthestPosition(List<Car> carList){
        int max = 0;
        for(Car car : carList){
            if(max < car.position){
                max = car.position;
            }
        }
        return max;
    }
}
