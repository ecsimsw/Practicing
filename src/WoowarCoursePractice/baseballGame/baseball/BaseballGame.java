package WoowarCoursePractice.baseballGame.baseball;

import WoowarCoursePractice.baseballGame.utils.NumbersFactory;
import WoowarCoursePractice.baseballGame.view.InputView;
import WoowarCoursePractice.baseballGame.view.OutputView;

import java.util.Scanner;

public class BaseballGame {

    private final Scanner scanner;
    private boolean isGameEnd = false;

    public BaseballGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void play(){
        Numbers target = NumbersFactory.createRandomNumbers();

        while(!isGameEnd){
            Numbers guess = InputView.getNumbers(scanner);

            int strikeCnt = GameRule.countStrike(target, guess);
            int ballCnt = GameRule.countBall(target, guess);

            OutputView.printScore(strikeCnt, ballCnt);
            checkGameOver(strikeCnt);
        }
        OutputView.printGameOver();
    }

    private void checkGameOver(int strikeCnt){
        if(GameRule.checkAllCorrect(strikeCnt)){
            isGameEnd = true;
        }
    }
}

