package WoowarCoursePractice.racingCar.src.view;

public class OutputView {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String SEPARATOR_NAME_POSITION = " : ";
    private static final String POSITION_BAR = "-";
    private static final String SEPARATOR_CAR = "\n";
    private static final String SEPARATOR_ROUND = "\n";

    private OutputView(){}

    public static void  printRacingResultMsg(){
        printMsg(RACING_RESULT_MESSAGE);
    }

    public static void printRoundScore(String name, int postion){
        printMsg(name);
        printMsg(SEPARATOR_NAME_POSITION);

        for(int i =0; i<postion; i++){
            printMsg(POSITION_BAR);
        }

        printMsg(SEPARATOR_CAR);
    }

    public static void printRoundSeparator(){
        printMsg(SEPARATOR_ROUND);
    }

    public static void printMsg(String msg){
        System.out.print(msg);
    }
}
