package personalProjects.KitechBusReader.repository;

import personalProjects.KitechBusReader.dto.History;
import personalProjects.KitechBusReader.dto.Result;

import java.util.LinkedList;
import java.util.List;

public class ResultRepository {
    private ResultRepository() {
    }

    private static List<Result> results = new LinkedList<>();

    public static void addResult(Result result) {
        results.add(result);
    }

    public static List<Result> getResults(){
        return results;
    }

    public static void printAll() {
        results.stream().forEach(result -> System.out.println(result));
    }
}
