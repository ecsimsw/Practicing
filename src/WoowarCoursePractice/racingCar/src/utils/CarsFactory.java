package WoowarCoursePractice.racingCar.src.utils;

import WoowarCoursePractice.racingCar.src.domain.Car;
import WoowarCoursePractice.racingCar.src.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    private static final String SEPARATOR_CAR_NAME = ",";

    private CarsFactory(){}

    public static Cars createCars(String nameLine) {
        List carList = Arrays.stream(nameLine.split(SEPARATOR_CAR_NAME))
                .map(name -> new Car(name))
                .collect(Collectors.toList());

        return new Cars(carList);
    }
}
