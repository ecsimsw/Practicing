package personalProjects.KitechBusReader.dto;

import java.time.LocalDateTime;

public class History {

    private String no;
    private String pid;
    private LocalDateTime localDateTime;

    public History(String no, String pid, LocalDateTime localDateTime) {
        this.no = no;
        this.pid = pid;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return no + " " + pid + " " + localDateTime.toString();
    }
}
