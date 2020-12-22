package personalProjects.KitechBusReader.dto;

public class User implements Comparable<User>{

    private String pid;
    private String name;
    private String section;
    private String cardId;

    public User(String pid, String name, String section, String cardId) {
        this.cardId = cardId;
        this.name = name;
        this.pid = pid;
        this.section = section;
    }

    public boolean isPid(String pid){
        return this.pid.equals(pid);
    }

    public String getPid(){
        return this.pid;
    }

    @Override
    public int compareTo(User o) {
        return this.pid.compareTo(o.pid);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            return ((User) o).pid == this.pid;
        }
        return false;
    }

    @Override
    public String toString() {
        return pid + ", " + name + ", " + section + ", " + cardId;
    }
}
