import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Depot depot = new Depot("Depot1");
        Client client1 = new Client("Client1", LocalTime.of(9, 0), LocalTime.of(17, 0), ClientType.REGULAR);
        Client client2 = new Client("Client2", LocalTime.of(8, 0), LocalTime.of(16, 0), ClientType.PREMIUM);
        Vehicle vehicle = new Vehicle("Vehicle1", depot, Arrays.asList(client1, client2));

        System.out.println(depot);
        System.out.println(vehicle);
        System.out.println(client1);
        System.out.println(client2);

        vehicle.tourClients();
    }
}