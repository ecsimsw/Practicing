package personalProjects.KitechBusReader.repository;

import personalProjects.KitechBusReader.dto.User;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    private UserRepository() {
    }

    private static final List<User> userList = new LinkedList<>();

    public static void addUser(User user) {
        userList.add(user);
    }

    public static void printAll() {
        userList.stream().forEach(user -> System.out.println(user));
    }

}
