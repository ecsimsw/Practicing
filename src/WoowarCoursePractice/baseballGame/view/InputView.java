package WoowarCoursePractice.baseballGame.view;

import WoowarCoursePractice.baseballGame.utils.Numbers;
import WoowarCoursePractice.baseballGame.utils.NumbersFactory;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MESSAGE = "숫자를 입력하시오. ";

    public static Numbers getNumbers(Scanner scanner) {
        OutputView.printMsg(ASK_NUMBER_MESSAGE);

        String input = scanner.nextLine();

        return NumbersFactory.createNumbers(input);
    }
}
