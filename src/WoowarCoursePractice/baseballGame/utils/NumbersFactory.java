package WoowarCoursePractice.baseballGame.utils;

import WoowarCoursePractice.baseballGame.baseball.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersFactory {
    private NumbersFactory(){}

    public static Numbers createRandomNumbers() {
        List<Integer> targetList = new ArrayList<>();

        while (targetList.size() < Numbers.LEN) {
            int rand = getRandWithoutDuplicate(targetList);
            targetList.add(rand);
        }

        return new Numbers(targetList);
    }

    private static int getRandWithoutDuplicate(List list) {
        int rand;

        do {
            rand = RandomUtils.nextInt(Numbers.MIN, Numbers.MAX);
        } while(list.contains(rand));

        return rand;
    }

    public static Numbers createNumbers(String number) {
        InputValidator.checkValidNumber(number);

        List numberList = Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(numberList);
    }
}
