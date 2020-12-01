package WoowarCoursePractice.baseballGame.view;

import WoowarCoursePractice.baseballGame.utils.Numbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class InputView {
    private static final String ASK_NUMBER_MESSAGE = "숫자를 입력하시오. ";

    public static Numbers getNumbers(Scanner scanner) {
        OutputView.printMsg(ASK_NUMBER_MESSAGE);

        String input = scanner.nextLine();

        List numberList = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(numberList);
    }
}
