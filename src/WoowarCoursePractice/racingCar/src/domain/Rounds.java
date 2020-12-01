package WoowarCoursePractice.racingCar.src.domain;

public class Rounds {
    private final int totalRound;
    private int currentRound = 0;

    public Rounds(int totalRound){
        this.totalRound = totalRound;
    }

    public void endRound(){
        currentRound++;
    }

    public boolean isEndAllRounds(){
        return currentRound >= totalRound;
    }
}
