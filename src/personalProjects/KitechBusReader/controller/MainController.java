package personalProjects.KitechBusReader.controller;

import personalProjects.KitechBusReader.repository.ResultRepository;
import personalProjects.KitechBusReader.repository.UserRepository;
import personalProjects.KitechBusReader.service.ExcelDataHandler;
import personalProjects.KitechBusReader.service.ExcelWriter;
import personalProjects.KitechBusReader.service.Search;
import personalProjects.KitechBusReader.service.TextDataHandler;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    // XXX :: CONSTANT
    private final static String userDataPath = "C:\\Users\\user\\Desktop\\버스직원데이터_test.xls";
    private final static int[] prices = new int[]{500,1500,1500,500};
    private final static String[] busNames = new String[]{"평택", "교대", "사당", "천안"};
//    private final static String[] busNames = new String[]{"평택", "교대", "사당", "천안"};
    //

    // XXX :: READ BY VIEW
    private final List<String> historyPaths;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;
    //

    public MainController(List<String> paths, LocalDate dateFrom, LocalDate dateTo) {
        this.historyPaths = paths;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public void run() {
        ExcelDataHandler excelDataHandler = ExcelDataHandler.getInstance();
        excelDataHandler.readUserData(userDataPath);

        TextDataHandler textDataHandler = new TextDataHandler();

        for(int busIndex =0; busIndex<historyPaths.size(); busIndex++){
            String busName= busNames[busIndex];
            int price = prices[busIndex];
            textDataHandler.readHistory(historyPaths.get(busIndex), dateFrom, dateTo, busName, price);
        }

        Search.search();
        ResultRepository.printAll();

        ExcelWriter excelWriter = new ExcelWriter("C:\\Users\\user\\Desktop\\버스데이터");
        excelWriter.writeExcelFile();
    }
}
