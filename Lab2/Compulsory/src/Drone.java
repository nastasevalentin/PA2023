import java.util.List;
import java.util.stream.Collectors;

public class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String name, Depot depot, List<Client> clients, int maxFlightDuration) {
        super(name, depot, clients);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "name='" + getName() + '\'' +
                ", depot=" + getDepot().getName() +
                ", clients=" + getClients().stream().map(Client::getName).collect(Collectors.joining(", ")) +
                ", flight duration=" + maxFlightDuration +
                '}';
    }

    @Override
    public void specificMethod() {
        System.out.println("This is a drone");
    }
}