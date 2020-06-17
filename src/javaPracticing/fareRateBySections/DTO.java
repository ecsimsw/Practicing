package javaPracticing.fareRateBySections;

public class DTO {
    String section = "";
    int position = 0;
    int fare = 0;

    public DTO(String section, int position, int fare){
        this.section = section;
        this.position = position;
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
