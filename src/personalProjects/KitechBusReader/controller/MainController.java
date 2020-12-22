package personalProjects.KitechBusReader.controller;

import personalProjects.KitechBusReader.repository.UserRepository;
import personalProjects.KitechBusReader.service.ExcelDataHandler;

public class MainController {

    public MainController(){

    }

    public void run(){
        ExcelDataHandler excelDataHandler = ExcelDataHandler.getInstance();
        String path = "C:\\Users\\user\\Desktop\\버스직원데이터_test.xls";
        excelDataHandler.readUserData(path);
        UserRepository.printAll();
    }
}
