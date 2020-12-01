package WoowarCoursePractice.baseballGame.baseball;

import WoowarCoursePractice.baseballGame.view.InputView;

import java.util.Scanner;

public class Application {
    private static final int PLAY_BUTTON_AGAIN = 1;
    private static final int PLAY_BUTTON_END = 2;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        do{
            BaseballGame baseballGame = new BaseballGame(scanner);
            baseballGame.play();
        }while(checkPlayAgain(scanner));
    }

    private static boolean checkPlayAgain(Scanner scanner){
        return InputView.getPlayAgainButton(scanner) == PLAY_BUTTON_AGAIN;
    }
}
