package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final int totalRound;

    private int currentRound;

    public RacingGame(Cars cars, int totalRound){
        this.cars = cars;
        this.totalRound = totalRound;
        currentRound = 0;
    }

    public void play(){
        OutputView.printRacingResultMsg();
        do{
            cars.move();
            printRoundScore();
            endRound();
        }while(!isGameEnd());
        printWinner();
    }

    private void printRoundScore(){
        cars.printPosition();
        OutputView.printRoundSeparator();
    }

    private void endRound(){
        currentRound++;
    }

    private boolean isGameEnd(){
        return totalRound == currentRound;
    }

    private void printWinner(){
        List<String> winnerNames = getWinnerNames();
        OutputView.printWinner(winnerNames);
    }

    private List getWinnerNames(){
        return cars.getWinnerNames();
    }
}
