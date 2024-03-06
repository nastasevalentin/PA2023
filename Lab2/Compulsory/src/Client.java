import java.time.LocalTime;

public class Client {
    private String name;
    private LocalTime[] visitingTimeInterval;
    private ClientType type;

    public Client(String name, LocalTime start, LocalTime end, ClientType type) {
        this.name = name;
        this.visitingTimeInterval = new LocalTime[]{start, end};
        this.type = type;
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
                "name='" + name + ",\'" +
                "type='" + type + "'"+
                ", visitingTimeInterval=" + visitingTimeInterval[0] + " - " + visitingTimeInterval[1] +
                '}';
    }
}