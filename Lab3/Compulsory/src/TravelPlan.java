import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    private Trip trip;
    private Map<LocalDate, List<Visitable>> plan;

    public TravelPlan(Trip trip) {
        this.trip = trip;
        this.plan = new HashMap<>();
    }

    public void addAttraction(LocalDate date, Visitable attraction) {
        this.plan.computeIfAbsent(date, k -> new ArrayList<>()).add(attraction);
    }

    public Map<LocalDate, List<Visitable>> getPlan() {
        return this.plan;
    }
}