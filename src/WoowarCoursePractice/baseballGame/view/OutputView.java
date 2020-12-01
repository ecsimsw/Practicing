package WoowarCoursePractice.baseballGame.view;

public class OutputView {
    private final static String PRINT_BALL_CNT_MESSAGE = "볼 ";
    private final static String PRINT_STRIKE_CNT_MESSAGE = "스트라이크 ";
    private final static String PRINT_NOTHING_MESSAGE = "낫싱";
    private final static String SEPARATOR_ROUND = "\n";
    private final static String GAME_OVER_MESSAGE = "다 맞췄습니다.";
    private OutputView(){}

    public static void printScore(int strikeCnt, int ballCnt){
        printBall(ballCnt);
        printStrike(strikeCnt);
        printIfNothing(ballCnt, strikeCnt);
        printMsg(SEPARATOR_ROUND);
    }

    private static void printBall(int ballCnt){
        if(ballCnt != 0){
            printMsg(ballCnt);
            printMsg(PRINT_BALL_CNT_MESSAGE);
        }
    }

    private static void printStrike(int strikeCnt){
        if(strikeCnt != 0){
            printMsg(strikeCnt);
            printMsg(PRINT_STRIKE_CNT_MESSAGE);
        }
    }

    private static void printIfNothing(int ballCnt, int StrikeCnt){
        if(ballCnt == 0 && StrikeCnt == 0){
            printMsg(PRINT_NOTHING_MESSAGE);
        }
    }

    public static void printGameOver(){
        printMsg(GAME_OVER_MESSAGE);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
