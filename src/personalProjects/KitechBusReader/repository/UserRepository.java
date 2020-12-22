package personalProjects.KitechBusReader.repository;

import personalProjects.KitechBusReader.dto.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private UserRepository() {
    }

    private static final Map<String, User> userTable = new HashMap<>();

    public static void addUser(User user) {
        userTable.put(user.getPid(), user);
    }

    public static void printAll() {
        for(User user : userTable.values()){
            System.out.println(user);
        }
    }

    public static Map<String, User> getUserTable(){
        return userTable;
    }
}
