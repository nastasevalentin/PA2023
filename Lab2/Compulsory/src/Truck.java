import java.util.List;
import java.util.stream.Collectors;

public class Truck extends Vehicle {
    private int capacity;

    public Truck(String name, Depot depot, List<Client> clients, int capacity) {
        super(name, depot, clients);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + getName() + '\'' +
                ", depot=" + getDepot().getName() +
                ", clients=" + getClients().stream().map(Client::getName).collect(Collectors.joining(", ")) +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public void specificMethod() {
        System.out.println("This is a truck");
    }
}