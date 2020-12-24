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
import java.util.concurrent.ExecutionException;

public class MainController {
    // XXX :: CONSTANT
    private final static String userDataPath = "C:\\Users\\user\\Desktop\\버스직원데이터_test.xls";
    private final static int[] prices = new int[]{500,1500,1500,500};
    private final static String[] busNames = new String[]{"평택", "교대", "사당", "천안"};
    private final static String basePath = "C:\\Users\\user\\Desktop\\버스데이터";
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

    public String run() {
        try {
            ExcelDataHandler excelDataHandler = ExcelDataHandler.getInstance();
            excelDataHandler.readUserData(userDataPath);
        } catch (Exception e) {
            return "잘못된 사원 정보 파일입니다.";
        }

        try {
            TextDataHandler textDataHandler = TextDataHandler.getInstance();
            for (int busIndex = 0; busIndex < historyPaths.size(); busIndex++) {
                String busName = busNames[busIndex];
                int price = prices[busIndex];
                textDataHandler.readHistory(historyPaths.get(busIndex), dateFrom, dateTo, busName, price);
            }
        }catch (Exception e){
            return "잘못된 버스 데이터 파일 입력입니다.";
        }

        Search.search();

        try{
            ExcelWriter excelWriter = new ExcelWriter(basePath);
            excelWriter.writeExcelFile();
        }catch (Exception e){
            return "잘못된 결과 목록 엑셀 파일 생성 위치입니다.";
        }

        return "검색 완료 : "+getDataCount()+"\n";
    }
    
    public int getDataCount(){
        return ResultRepository.getSize();
    }
}
