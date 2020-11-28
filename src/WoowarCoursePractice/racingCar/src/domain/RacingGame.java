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
        do{
            tryMovingCar();
            printRoundScore();
            endRound();
        }while(isGameEnd());
    }

    private boolean isGameEnd(){
        return totalRound == currentRound;
    }

    private void tryMovingCar(){
        carList.stream().forEach(car-> car.tryMove());
    }

    private void printRoundScore(){

    }

    private void endRound(){
        currentRound++;
    }
}
