package personalProjects.KitechBusReader.service;

import personalProjects.KitechBusReader.dto.History;
import personalProjects.KitechBusReader.dto.Result;
import personalProjects.KitechBusReader.dto.User;
import personalProjects.KitechBusReader.repository.HistoryRepository;
import personalProjects.KitechBusReader.repository.ResultRepository;
import personalProjects.KitechBusReader.repository.UserRepository;

import java.util.Collections;
import java.util.List;

public class Search {

    public static void search(){
        List<History> histories = HistoryRepository.getHistories();
        List<User> users = UserRepository.getUserList();


    }

    private static void sortData(){
        List<History> histories = HistoryRepository.getHistories();
        List<User> users = UserRepository.getUserList();

        Collections.sort(histories);
        Collections.sort(users);
    }

    private static void saveResult(User user, History history){
        ResultRepository.addResult(new Result(user, history));
    }
}
