package javaPracticing.fareRateBySections;

import java.util.List;

public class DAO implements ICSV {
    @Override
    public List<DTO> loadCSV(String fileName) {
        return null;
    }

    @Override
    public boolean saveCSV(List<DTO> lines) {
        return false;
    }
}
