import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Statue statue = new Statue("The Thinker", 3);
        Church church = new Church("Notre Dame", 0);
        Concert concert = new Concert("Rock Concert", 100);
        List<Visitable> attractions = Arrays.asList(statue, church, concert);
        Trip trip = new Trip("Paris", "3 days", attractions);

        concert.getTimetable().addTimeSlot("2023-05-01", "18:00 - 22:00");
        church.getTimetable().addTimeSlot("2023-05-02", "09:00 - 18:00");

        LocalTime openingHour = concert.getOpeningHour("2023-05-01");
        System.out.println("Concert opening hour: " + openingHour);

        TravelPlan travelPlan = new TravelPlan(trip);
        travelPlan.addAttraction(LocalDate.parse("2023-05-16"), concert);
        travelPlan.addAttraction(LocalDate.parse("2023-05-15"), church);

        trip.displayFreeVisitableLocations();
        System.out.println();

        System.out.println("Travel Plan:");
        for (Map.Entry<LocalDate, List<Visitable>> entry : travelPlan.getPlan().entrySet()) {
            System.out.println("Date: " + entry.getKey());
            for (Visitable visitable : entry.getValue()) {
                System.out.println("Attraction: " + visitable.getName());
            }
        }
    }
}