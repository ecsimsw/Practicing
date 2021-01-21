package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2525_구현_오븐시계 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] HM = br.readLine().split(" ");
        int takenMinutes = Integer.parseInt(br.readLine());

        int minuteSum = Integer.parseInt(HM[1]) + takenMinutes;

        int takenHours = minuteSum / 60;
        int timeSum = Integer.parseInt(HM[0]) + takenHours;

        int minute = minuteSum % 60;
        int hour = timeSum % 24;

        System.out.print(hour + " " + minute);
    }
}
