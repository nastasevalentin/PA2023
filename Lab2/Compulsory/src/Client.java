import java.time.LocalTime;
import java.util.Objects;

public class Client {
    private String name;
    private LocalTime start;
    private LocalTime end;
    private ClientType type;

    public Client(String name, LocalTime start, LocalTime end, ClientType type) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}