package personalProjects.KitechBusReader.service;

import WoowarCoursePractice.racingCar.src.view.OutputView;
import personalProjects.KitechBusReader.dto.History;
import personalProjects.KitechBusReader.repository.HistoryRepository;

import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TextDataHandler {
    private static final int NO_INDEX = 0;
    private static final int PID_INDEX = 1;
    private static final int DATE_INDEX = 9;
    private static final String SEPARATOR = "\t";
    private static final String INVALID_PID_CODE = "-00001";

    public TextDataHandler() {
    }

    public void readHistory(String filePath, LocalDate from, LocalDate to) {
        try {
            File file = new File("C:\\Users\\user\\Desktop\\GLOG_003.TXT");

            if (file.exists()) {
                BufferedReader inFile = new BufferedReader(new FileReader(file));

                String line = null;
                inFile.readLine();
                while ((line = inFile.readLine()) != null) {
                    String[] splited = line.split(SEPARATOR);
                    String no = splited[NO_INDEX];
                    String pid = String.format("%06d", Integer.parseInt(splited[PID_INDEX]));
                    LocalDateTime dateTime = LocalDateTime.parse(splited[DATE_INDEX],
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    if (isInvalidPID(pid)) {
                        continue;
                    }

                    if (isNotInRange(from, to, dateTime)) {
                        continue;
                    }

                    saveInRepository(new History(no, pid, dateTime));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isInvalidPID(String pid) {
        return pid.equals(INVALID_PID_CODE);
    }

    private boolean isNotInRange(LocalDate from, LocalDate to, LocalDateTime dateTime) {
        return dateTime.isBefore(from.atTime(0, 0)) || dateTime.isAfter(to.atTime(12, 50));
    }

    private void saveInRepository(History history) {
        HistoryRepository.addHistory(history);
    }
}
