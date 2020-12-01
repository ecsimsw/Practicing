package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.view.InputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Cars cars = InputView.getCars(scanner);
        final int totalRound = InputView.getTotalRound(scanner);

        RacingGame racingGame = new RacingGame(cars, totalRound);
        racingGame.play();
    }
}