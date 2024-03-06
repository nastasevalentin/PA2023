import java.time.LocalTime;

public class Client {
    private String name;
    private LocalTime[] visitingTimeInterval;

    public Client(String name, LocalTime start, LocalTime end) {
        this.name = name;
        this.visitingTimeInterval = new LocalTime[]{start, end};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime[] getVisitingTimeInterval() {
        return visitingTimeInterval;
    }

    public void setVisitingTimeInterval(LocalTime start, LocalTime end) {
        this.visitingTimeInterval = new LocalTime[]{start, end};
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", visitingTimeInterval=" + visitingTimeInterval[0] + " - " + visitingTimeInterval[1] +
                '}';
    }
}