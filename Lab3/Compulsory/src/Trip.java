import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Trip {
    private String destination;
    private String duration;
    private List<Visitable> attractions;

    public Trip(String destination, String duration, List<Visitable> attractions) {
        this.destination = destination;
        this.duration = duration;
        this.attractions = attractions;
    }

    public void displayFreeVisitableLocations() {
        List<Visitable> freeVisitableLocations = new ArrayList<>();

        for (Visitable attraction : attractions) {
            if (attraction instanceof Payable) {
                Payable payableAttraction = (Payable) attraction;
                if (payableAttraction.getPrice() == 0) {
                    freeVisitableLocations.add(attraction);
                }
            } else {
                freeVisitableLocations.add(attraction);
            }
        }

        freeVisitableLocations.sort(Comparator.comparing(o -> o.getTimetable().getOpeningHour(LocalDate.now().toString())));
        System.out.println("Free visitable locations in " + destination + ":");
        for (Visitable location : freeVisitableLocations) {
            System.out.println(location.getName());
        }
    }
}