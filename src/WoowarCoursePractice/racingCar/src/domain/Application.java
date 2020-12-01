package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.utils.CarsFactory;
import WoowarCoursePractice.racingCar.src.utils.InputValidator;
import WoowarCoursePractice.racingCar.src.view.InputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Cars cars = InputView.getCars(scanner);
        final int totalRound = askRoundCount(scanner);

        RacingGame racingGame = new RacingGame(cars, totalRound);
        racingGame.play();
    }

    private static int askRoundCount(Scanner scanner){
        try{
            String inputRoundCount = readRoundCount(scanner);
            InputValidator.isValidTryCountInput(inputRoundCount);
            return Integer.parseInt(inputRoundCount);
        }catch (IllegalArgumentException IA){
            IA.printStackTrace();
            return askRoundCount(scanner);
        }
    }

    private static String readRoundCount(Scanner scanner){
        return InputView.askNumberOfRound(scanner);
    }
}