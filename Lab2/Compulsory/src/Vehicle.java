import java.util.List;
import java.util.Objects;

public abstract class Vehicle {
    private String name;
    private Depot depot;
    private List<Client> clients;

    public Vehicle(String name, Depot depot, List<Client> clients) {
        this.name = name;
        this.depot = depot;
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public Depot getDepot() {
        return depot;
    }

    public List<Client> getClients() {
        return clients;
    }

    public abstract void specificMethod();
}