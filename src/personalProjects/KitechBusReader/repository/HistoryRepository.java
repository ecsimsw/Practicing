package personalProjects.KitechBusReader.repository;

import personalProjects.KitechBusReader.dto.History;

import java.util.LinkedList;
import java.util.List;

public class HistoryRepository {

    private HistoryRepository() {
    }

    public static List<History> histories = new LinkedList<>();

    public static void addHistory(History history) {
        histories.add(history);
    }

    public static void printAll() {
        histories.stream().forEach(history -> System.out.println(history));
    }
}
