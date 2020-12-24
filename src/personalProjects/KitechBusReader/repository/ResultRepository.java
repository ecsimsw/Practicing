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

    public static int getSize(){
        return results.size();
    }

    public static List<Result> getResults(){
        return results;
    }
}
