package WoowarCoursePractice.racingCar.src.utils;

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
}
