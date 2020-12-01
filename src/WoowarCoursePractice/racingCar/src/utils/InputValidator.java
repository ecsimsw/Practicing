package WoowarCoursePractice.racingCar.src.utils;

import WoowarCoursePractice.racingCar.src.domain.Car;

public class InputValidator {
    private InputValidator(){}

    public static void checkValidCarName(String name) {
        if (!isValidLength(name, Car.NAME_LENGTH_MIN, Car.NAME_LENGTH_MAX)) {
            throw new IllegalArgumentException("잘못된 길이의 자동차 이름입니다.");
        }
    }

    private static boolean isValidLength(String line, int min,int max) {
        return line.length() >= min && line.length() <= max;
    }
}
