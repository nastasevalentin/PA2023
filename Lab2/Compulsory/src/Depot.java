import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Depot {
    private String name;
    private List<Vehicle> vehicles;

    public Depot(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}