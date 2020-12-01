package WoowarCoursePractice.baseballGame.view;

import WoowarCoursePractice.baseballGame.baseball.Numbers;
import WoowarCoursePractice.baseballGame.utils.NumbersFactory;

import java.util.Scanner;

public class InputView {
    private static final String ASK_NUMBER_MESSAGE = "숫자를 입력하시오. \n";
    private static final String ASK_PLAY_AGAIN_BUTTON = "다시 진행하려면 1, 종료는 2를 입력해주세요. \n";

    public static Numbers getNumbers(Scanner scanner) {
        OutputView.printMsg(ASK_NUMBER_MESSAGE);

        try{
            String input = getInput(scanner);
            return NumbersFactory.createNumbers(input);
        }catch (IllegalArgumentException IAE){
            IAE.printStackTrace();
            return getNumbers(scanner);
        }
    }

    public static int getPlayAgainButton(Scanner scanner){
        OutputView.printMsg(ASK_PLAY_AGAIN_BUTTON);

        String input = getInput(scanner);

        return Integer.parseInt(input);
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
