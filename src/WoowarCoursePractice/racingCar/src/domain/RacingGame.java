package WoowarCoursePractice.racingCar.src.domain;

import WoowarCoursePractice.racingCar.src.view.OutputView;

public class RacingGame {
    private final Cars cars;
    private final Rounds rounds;

    public RacingGame(Cars cars, int totalRound){
        this.cars = cars;
        rounds = new Rounds(totalRound);
    }

    public void play(){
        OutputView.printRacingResultMsg();
        do{
            cars.move();
            printRoundScore();
            rounds.endRound();
        }while(!rounds.isEndAllRounds());
        printWinner();
    }

    private void printRoundScore(){
        cars.printPosition();
        OutputView.printRoundSeparator();
    }

    private void printWinner(){
        OutputView.printWinner(cars.getWinnerNames());
    }
}
