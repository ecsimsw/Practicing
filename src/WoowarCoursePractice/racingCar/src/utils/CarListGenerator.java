package WoowarCoursePractice.racingCar.src.utils;

import WoowarCoursePractice.racingCar.src.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarListGenerator {
    private CarListGenerator(){}

    public static List<Car> createCarList(String nameLine, String nameSeparator){
        List<Car> carList = new ArrayList<>();
        for(String name : nameLine.split(nameSeparator)){
            carList.add(new Car(name));
        }
        return carList;
    }
}
