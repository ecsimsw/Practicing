package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.view.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.stream().forEach(car -> car.tryMove());
    }

    public void printPosition() {
        cars.stream().forEach(car -> OutputView.printRoundScore(car.name, car.position));
    }

    public List<String> getWinnerNames() {
        int farthestPosition = findFarthestPosition();
        return cars.stream()
                .filter(car -> car.position == farthestPosition)
                .map(car -> car.name)
                .collect(Collectors.toList());
    }

    public int findFarthestPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(car -> car.position))
                .get()
                .position;
    }
}
