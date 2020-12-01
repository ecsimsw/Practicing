package WoowarCoursePractice.baseballGame.baseball;

public class GameRule {

    private GameRule(){}

    public static int countStrike(Numbers target, Numbers guess){
        return (int)guess.getStream()
                .filter(num -> target.get(guess.indexOf(num)) == num)
                .count();
    }

    public static int countBall(Numbers target, Numbers guess){
        return (int)guess.getStream()
                .filter(num -> target.contains(num))
                .count()
                - countStrike(target, guess);
    }

    public static boolean checkAllCorrect(int strikeCnt){
        return strikeCnt == Numbers.LEN;
    }
}
