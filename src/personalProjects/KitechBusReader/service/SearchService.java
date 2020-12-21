package personalProjects.KitechBusReader.service;

import java.io.FileInputStream;
import java.time.LocalDateTime;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.util.Date;

public class SearchService {
    private static SearchService searchService;

    private Date dateFrom;
    private Date dateTo;

    private SearchService() {

    }

    public static SearchService getInstance() {
        if (searchService == null) {
            searchService = new SearchService();
        }
        return searchService;
    }

    public void search(Date from, Date to, String user, String history) {

    }

    public void readUserData(String path) {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\버스직원데이터_.xls");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int rowindex = 0;
            int columnindex = 0;
            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            XSSFSheet sheet = workbook.getSheetAt(0);
            //행의 수
            int rows = sheet.getPhysicalNumberOfRows();
            for (rowindex = 0; rowindex < 10; rowindex++) {
                //행을읽는다
                XSSFRow row = sheet.getRow(rowindex);
                if (row != null) {
                    //셀의 수
                    int cells = row.getPhysicalNumberOfCells();
                    String value = "";
                    for (columnindex = 0; columnindex <= cells; columnindex++) {
                        //셀값을 읽는다
                        XSSFCell cell = row.getCell(columnindex);
                        //셀이 빈값일경우를 위한 널체크
                        if (cell == null) {
                            continue;
                        } else {
                            value += cell.getErrorCellValue() + "";
                        }
                    }
                    System.out.println(rowindex + "번 행 : " + columnindex + "번 열 값은: " + value);
                }

            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
