import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Depot depot1 = new Depot("Depot1");
        Depot depot2 = new Depot("Depot2");

        Client client1 = new Client("Client1", LocalTime.of(9, 0), LocalTime.of(17, 0), ClientType.REGULAR);
        Client client2 = new Client("Client2", LocalTime.of(8, 0), LocalTime.of(16, 0), ClientType.PREMIUM);
        Client client3 = new Client("Client3", LocalTime.of(10, 0), LocalTime.of(18, 0), ClientType.REGULAR);
        Client client4 = new Client("Client4", LocalTime.of(11, 0), LocalTime.of(19, 0), ClientType.PREMIUM);

        List<Client> clientsTruck = new ArrayList<>(Arrays.asList(client1, client2));
        List<Client> clientsDrone = new ArrayList<>(Arrays.asList(client3, client4));


        Truck truck = new Truck("Truck1", depot1, clientsTruck, 1000);
        Drone drone = new Drone("Drone1", depot2, clientsDrone, 120);

        depot1.addVehicle(truck);
        depot2.addVehicle(drone);

        Problem problem = new Problem(Arrays.asList(depot1, depot2));
        Vehicle[] vehicles = problem.getVehicles();
        System.out.println(Arrays.toString(vehicles));
    }
}