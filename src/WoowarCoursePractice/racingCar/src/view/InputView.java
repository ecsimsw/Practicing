package WoowarCoursePractice.racingCar.src.view;

import WoowarCoursePractice.racingCar.src.domain.Cars;
import WoowarCoursePractice.racingCar.src.utils.CarsFactory;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하시오. (이름은 쉼표(,) 기준으로 구분\n";
    private static final String SEPARATOR_LINE = "\n";
    private static final String ASK_NUMBER_OF_ROUND_MESSAGE = "시도할 횟수는 몇회인가요.";

    private InputView(){}

    public static Cars getCars(Scanner scanner){
        OutputView.printMsg(ASK_CAR_NAME_MESSAGE);
        try{
            String userInput = getInput(scanner);
            return CarsFactory.createCars(userInput);
        }catch (IllegalArgumentException IAE){
            return getCars(scanner);
        }
    }

    public static String askNumberOfRound(Scanner scanner){
        OutputView.printMsg(ASK_NUMBER_OF_ROUND_MESSAGE);
        OutputView.printMsg(SEPARATOR_LINE);
        return scanner.nextLine();
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
