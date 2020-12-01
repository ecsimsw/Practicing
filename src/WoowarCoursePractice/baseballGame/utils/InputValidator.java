package WoowarCoursePractice.baseballGame.utils;

import java.util.Arrays;

public class InputValidator {
    private static final String INVALID_LENGTH = "적절하지 않은 입력 길이입니다.";
    private static final String INVALID_DUPLICATED = "중복된 입력입니다.";
    private static final String INVALID_RANGE = "범위 밖 문자 입력입니다.";

    private InputValidator(){}

    public static void checkValidNumber(String input) throws IllegalArgumentException{
        if(!isValidLength(input, Numbers.LEN)){
            throw new IllegalArgumentException(INVALID_LENGTH);
        }

        if(!isAllDifferent(input)){
           throw new IllegalArgumentException(INVALID_DUPLICATED);
        }

        if(!isInRange(input, Numbers.MIN, Numbers.MAX)){
            throw new IllegalArgumentException(INVALID_RANGE);
        }

    }

    private static boolean isValidLength(String input, int len){
        return input.length() == len;
    }

    private static boolean isInRange(String input, int min, int max){
        if(!isNumeric(input)){
            return false;
        }

        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .allMatch(num -> num >= min && num <= max );
    }

    private static boolean isNumeric(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static boolean isAllDifferent(String input){
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == input.length();
    }
}
