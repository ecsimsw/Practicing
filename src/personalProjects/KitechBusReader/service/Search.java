package personalProjects.KitechBusReader.service;

import personalProjects.KitechBusReader.dto.History;
import personalProjects.KitechBusReader.dto.Result;
import personalProjects.KitechBusReader.dto.User;
import personalProjects.KitechBusReader.repository.HistoryRepository;
import personalProjects.KitechBusReader.repository.ResultRepository;
import personalProjects.KitechBusReader.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Search {

    public static void search(){
        List<History> histories = HistoryRepository.getHistories();
        Collections.sort(histories);

        Map<String, User> userTable = UserRepository.getUserTable();
        int size_history = histories.size();

        int index_history = 0;

        while(index_history < size_history){
            String pid = histories.get(index_history).getPid();

            if(userTable.containsKey(pid)){
                User user = userTable.get(pid);
                List<History> sameUsers = HistoryRepository.getAllSameUsers(user);

                saveResult(user, sameUsers);
                index_history += sameUsers.size();
            }
            if(!userTable.containsKey(pid)){
                index_history++;
            }
        }
    }

    private static void saveResult(User user, List<History> historiesSameUser){
        for(History history : historiesSameUser){
            user.updatePrice(history.getPrice());
            ResultRepository.addResult(new Result(user, history));
        }
    }
}
