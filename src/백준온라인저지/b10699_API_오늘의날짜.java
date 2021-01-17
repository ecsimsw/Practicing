package 백준온라인저지;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class b10699_API_오늘의날짜 {
    public static void main(String[] args)throws Exception{
        LocalDateTime ldt = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String string = ldt.format(dateTimeFormatter);

        System.out.println(string);
    }
}
