import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Depot> depots;

    public Problem(List<Depot> depots) {
        this.depots = depots;
    }

    public Vehicle[] getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Depot depot : depots) {
            vehicles.addAll(depot.getVehicles());
        }
        return vehicles.toArray(new Vehicle[0]);
    }
}