package WoowarCoursePractice.racingCar.src.utils;

import java.util.Arrays;

public class InputValidator {
    private static final String SEPARATOR_NAME =",";
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    private InputValidator(){}

    public static void checkValidCarName(String name) throws IllegalArgumentException{
        if(!isValidLength(name, NAME_LENGTH_MIN, NAME_LENGTH_MAX)) {
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하 입니다.");
        }
    }

    private static boolean isValidLength(String line,int min,int max){
        return line.length() >= min && line.length() <= max;
    }

    public static void isValidTryCountInput(String line) throws IllegalArgumentException{
        if(!isNumeric(line)){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static boolean isNumeric(String line){
        try{
            Integer.parseInt(line);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
