package personalProjects.KitechBusReader.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History implements Comparable<History>{
    private String pid;
    private LocalDateTime localDateTime;

    public History(String pid, LocalDateTime localDateTime) {
        this.pid = pid;
        this.localDateTime = localDateTime;
    }

    public boolean isUser(User user){
        return user.isPid(this.pid);
    }

    public String getDateTimeString(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return current.format(formatter);
    }

    @Override
    public int compareTo(History o) {
        return this.pid.compareTo(o.pid);
    }

    @Override
    public String toString() {
        return pid + " " + localDateTime.toString();
    }
}
