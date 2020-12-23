package personalProjects.KitechBusReader.service;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import personalProjects.KitechBusReader.dto.Result;
import personalProjects.KitechBusReader.dto.User;
import personalProjects.KitechBusReader.repository.ResultRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelWriter {
    private final String basePath;

    public ExcelWriter(String basePath) {
        this.basePath = basePath;
    }

    public void writeExcelFile(){
        FileOutputStream fos = null;
        XSSFWorkbook workbook = null;

        try{
            File file = new File(makeFilePath());
            fos = new FileOutputStream(file);
            workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("data");
            writeResult(sheet);
        }catch (IOException e ) {
            e.printStackTrace();
        } finally {
            try {
                workbook.write(fos);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String makeFilePath(){
        String dateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        return basePath +"\\"+ dateTimeString + ".xlsx";
    }

    private void writeResult(XSSFSheet sheet){
        List<Result> results = ResultRepository.getResults();

        int row = 0;
        int index = 0;
        int total_index = results.size();

        User prevUser = null;

        while (index < total_index) {
            Result result = results.get(index);
            User user = result.getUser();

            XSSFRow curRow = sheet.createRow(row);
            if (prevUser != user) {
                row++; // 빈 라인
                curRow = sheet.createRow(row);
                createResultSummery(curRow, result);
                row++;
                prevUser = user;
            } else {
                createDetail(curRow, result);
                index++;
                row++;
            }
        }
    }

    private void createResultSummery(XSSFRow curRow, Result result) {
        curRow.createCell(0).setCellValue(result.getPid());
        curRow.createCell(1).setCellValue(result.getName());
        curRow.createCell(2).setCellValue(result.getSection());
        curRow.createCell(3).setCellValue(result.getTotalPrice());
    }

    private void createDetail(XSSFRow curRow, Result result){
        curRow.createCell(0).setCellValue(result.getPid());
        curRow.createCell(1).setCellValue(result.getName());
        curRow.createCell(2).setCellValue(result.getCardId());
        curRow.createCell(3).setCellValue(result.getBusPrice());
        curRow.createCell(4).setCellValue(result.getBusName());
        curRow.createCell(5).setCellValue(result.getUsageTime());
    }
}
