package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> carList;
    private final int totalRound;

    private int currentRound;

    public RacingGame(List<Car> carList, int totalRound){
        this.carList = carList;
        this.totalRound = totalRound;
        currentRound = 0;
    }

    public void play(){
        printRacingResultMsg();
        do{
            tryMovingCar();
            printRoundScore();
            endRound();
        }while(!isGameEnd());
        printWinner();
    }

    private void printRacingResultMsg(){
        OutputView.printRacingResultMsg();
    }

    private void tryMovingCar(){
        carList.stream().forEach(car-> car.tryMove());
    }

    private void printRoundScore(){
        carList.stream()
                .forEach(car -> OutputView.printRoundScore(car.name, car.position));
        OutputView.printRoundSeparator();
    }

    private void endRound(){
        currentRound++;
    }

    private boolean isGameEnd(){
        return totalRound == currentRound;
    }

    private void printWinner(){
        List winnerNames = getWinnerNames();
        OutputView.printWinner(winnerNames);
    }

    private List getWinnerNames(){
        return GameRule.findWinner(carList).stream()
                .map(car -> car.name)
                .collect(Collectors.toList());
    }
}
