package personalProjects.KitechBusReader;

import personalProjects.KitechBusReader.controller.MainController;
import personalProjects.KitechBusReader.service.ExcelDataHandler;

public class BusCardDataReaderApp {

    public static void main(String[] args){
//        MainView mainView = new MainView();

//        FileView.run();
        MainController mainController = new MainController();
        mainController.run();
    }
}
