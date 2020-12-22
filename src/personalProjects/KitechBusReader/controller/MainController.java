package personalProjects.KitechBusReader.controller;

import personalProjects.KitechBusReader.repository.ResultRepository;
import personalProjects.KitechBusReader.repository.UserRepository;
import personalProjects.KitechBusReader.service.ExcelDataHandler;
import personalProjects.KitechBusReader.service.Search;
import personalProjects.KitechBusReader.service.TextDataHandler;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    private final List<String> historyPaths;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public MainController(List<String> paths, LocalDate dateFrom, LocalDate dateTo) {
        this.historyPaths = paths;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public void run() {
        ExcelDataHandler excelDataHandler = ExcelDataHandler.getInstance();
        String userDataPath = "C:\\Users\\user\\Desktop\\버스직원데이터_test.xls";
        excelDataHandler.readUserData(userDataPath);


        TextDataHandler textDataHandler = new TextDataHandler();
        for(String historyPath : historyPaths){
            textDataHandler.readHistory(historyPath, dateFrom, dateTo);
        }

        Search.search();
        ResultRepository.printAll();
    }
}
