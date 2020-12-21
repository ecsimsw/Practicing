package personalProjects.KitechBusReader;

import personalProjects.KitechBusReader.backUp.FileViewBackup;
import personalProjects.KitechBusReader.service.SearchService;
import personalProjects.KitechBusReader.view.FileView;
import personalProjects.KitechBusReader.view.MainView;

public class BusCardDataReaderApp {

    public static void main(String[] args){
//        MainView mainView = new MainView();

//        FileView.run();
        SearchService searchService = SearchService.getInstance();
        searchService.readUserData("");
    }
}
