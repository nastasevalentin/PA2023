import java.util.List;

public class Trip {
    private String city;
    private String period;
    private List<Visitable> attractions;

    public Trip(String city, String period, List<Visitable> attractions) {
        this.city = city;
        this.period = period;
        this.attractions = attractions;
    }

}