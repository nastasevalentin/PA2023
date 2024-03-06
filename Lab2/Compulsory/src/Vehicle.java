import java.util.List;

public class Vehicle {
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

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public void returnToDepot() {
        System.out.println(name + " is returning to " + depot.getName());
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void tourClients() {
        System.out.println(name + " is starting from " + depot.getName());
        for (Client client : clients) {
            System.out.println(name + " is visiting " + client.getName());
        }
        System.out.println(name + " is returning to " + depot.getName());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot.getName() +
                '}';
    }
}