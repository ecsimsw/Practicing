package personalProjects.KitechBusReader.service;

import WoowarCoursePractice.racingCar.src.view.OutputView;
import personalProjects.KitechBusReader.dto.History;
import personalProjects.KitechBusReader.repository.HistoryRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextDataHandler {
    private static final int NO_INDEX = 0;
    private static final int PID_INDEX = 1;
    private static final int DATE_INDEX = 9;
    private static final String SEPARATOR = "\t";

    public TextDataHandler() {
    }

    public void readHistory(String filePath) {
        try {
            //파일 객체 생성
            File file = new File("C:\\Users\\user\\Desktop\\GLOG_003.TXT");

            if (file.exists()) {
                BufferedReader inFile = new BufferedReader(new FileReader(file));

                String line = null;
                inFile.readLine();
                while ((line = inFile.readLine()) != null){
                    History history = parseToHistory(line);
                    saveInRepository(history);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private History parseToHistory(String line){
        String[] splited = line.split(SEPARATOR);
        String no = splited[NO_INDEX];
        String pid= String.format("%06d", Integer.parseInt(splited[PID_INDEX]));
        LocalDateTime date = LocalDateTime.parse(splited[DATE_INDEX], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return new History(no, pid, date);
    }

    private void saveInRepository(History history){
        HistoryRepository.addHistory(history);
    }
}
