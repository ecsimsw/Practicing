package WoowarCoursePractice.baseballGame.baseball;

import WoowarCoursePractice.baseballGame.utils.GameRule;
import WoowarCoursePractice.baseballGame.utils.Numbers;
import WoowarCoursePractice.baseballGame.utils.RandomUtils;
import WoowarCoursePractice.baseballGame.view.InputView;
import WoowarCoursePractice.baseballGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    private final Scanner scanner;
    private boolean isGameEnd = false;

    public BaseballGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void play(){
        Numbers target = setTargetNumber();

        while(!isGameEnd){
            Numbers guess = InputView.getNumbers(scanner);

            int strikeCnt = GameRule.countStrike(target, guess);
            int ballCnt = GameRule.countBall(target, guess);

            OutputView.printScore(strikeCnt, ballCnt);
            checkGameOver(strikeCnt);
        }
        OutputView.printGameOver();
    }

    private Numbers setTargetNumber(){
        List<Integer> targetList = new ArrayList<>();

        while(targetList.size() < Numbers.LEN){
            int rand = getRandWithoutDuplicate(targetList);
            targetList.add(rand);
        }

        return new Numbers(targetList);
    }

    private int getRandWithoutDuplicate(List list){
        int rand;

        do{
            rand = RandomUtils.nextInt(Numbers.MIN, Numbers.MAX);
        }while(list.contains(rand));

        return rand;
    }

    private void checkGameOver(int strikeCnt){
        if(GameRule.checkAllCorrect(strikeCnt)){
            isGameEnd = true;
        }
    }
}

