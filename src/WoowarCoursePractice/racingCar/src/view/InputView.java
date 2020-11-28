package WoowarCoursePractice.racingCar.src.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하시오";
    private static final String SEPARATOR_CAR_NAME_MESSAGE = "(이름은 쉼표(,) 기준으로 구분";
    private static final String SEPARATOR_LINE = "\n";
    private static final String ASK_NUMBER_OF_ROUND_MESSAGE = "시도할 횟수는 몇회인가요.";

    private InputView(){}

    public static String askCarNames(Scanner SCANNER){
        OutputView.printMsg(ASK_CAR_NAME_MESSAGE);
        OutputView.printMsg(SEPARATOR_CAR_NAME_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);
        return SCANNER.nextLine();
    }

    public static String askNumberOfRound(Scanner SCANNER){
        OutputView.printMsg(ASK_NUMBER_OF_ROUND_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);
        return SCANNER.nextLine();
    }
}
