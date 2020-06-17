package javaPracticing.fareRateBySections;

import java.util.*;

public interface ICSV {
    List<DTO> loadCSV(String fileName);
    boolean saveCSV(List<DTO> lines);
}
