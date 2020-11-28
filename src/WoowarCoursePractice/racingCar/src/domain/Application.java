package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.utils.CarListGenerator;
import WoowarCoursePractice.racingCar.src.utils.InputValidator;
import WoowarCoursePractice.racingCar.src.view.InputView;

import java.util.Scanner;
import java.util.List;

public class Application {
    private static final String SEPARATOR_CAR_NAME = ",";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Car> carList = setCarList(scanner);
        final int totalRound = askRoundCount(scanner);

        RacingGame racingGame = new RacingGame(carList, totalRound);
        racingGame.play();
    }

    private static List<Car> setCarList(Scanner scanner){
        return CarListGenerator.createCarList(askCarName(scanner), SEPARATOR_CAR_NAME);
    }

    private static String askCarName(Scanner scanner){
        try{
            String inputCarNames = readCarName(scanner);
            InputValidator.isValidCarNameInput(inputCarNames);
            return inputCarNames;
        }catch (IllegalArgumentException IAE){
            IAE.printStackTrace();
            return askCarName(scanner);
        }
    }

    private static String readCarName(Scanner scanner){
        return InputView.askCarNames(scanner);
    }

    private static int askRoundCount(Scanner scanner){
        try{
            String inputRoundCount = readRoundCount(scanner);
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