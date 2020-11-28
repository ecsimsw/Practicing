package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.view.OutputView;

import java.util.List;

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
}
