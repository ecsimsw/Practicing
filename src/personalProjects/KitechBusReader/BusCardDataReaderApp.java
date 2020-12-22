package personalProjects.KitechBusReader;

import personalProjects.KitechBusReader.controller.MainController;
import personalProjects.KitechBusReader.repository.HistoryRepository;
import personalProjects.KitechBusReader.service.ExcelDataHandler;
import personalProjects.KitechBusReader.service.TextDataHandler;
import personalProjects.KitechBusReader.view.FileView;
import personalProjects.KitechBusReader.view.MainView;

import java.time.LocalDate;

public class BusCardDataReaderApp {

    public static void main(String[] args){
//        MainView mainView = new MainView();
//
//        FileView.run();
//        MainController mainController = new MainController();
//        mainController.run();

        TextDataHandler textDataHandler = new TextDataHandler();
        textDataHandler.readHistory("", LocalDate.of(2020,11,01), LocalDate.of(2020,12,01));

        HistoryRepository.printAll();
    }
}
