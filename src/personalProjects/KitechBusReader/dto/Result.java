package personalProjects.KitechBusReader.dto;

import java.time.LocalDateTime;

public class Result implements Comparable<Result>{
    private User user;
    private History history;

    public Result(User user, History dateTime){
        this.user = user;
        this.history = dateTime;
    }

    @Override
    public String toString(){
        return user.toString() + ", " + history.toString();
    }

    @Override
    public int compareTo(Result o) {
        return this.user.compareTo(o.user);
    }
}
