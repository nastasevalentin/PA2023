import java.time.LocalTime;
import java.util.Map;
import java.util.HashMap;

public class Timetable {
    private Map<String, String> schedule;

    public Timetable() {
        this.schedule = new HashMap<>();
    }

    public LocalTime getOpeningHour(String date) {
        String timeSlot = schedule.get(date);
        if (timeSlot != null) {
            String openingHour = timeSlot.split(" - ")[0].trim();
            return LocalTime.parse(openingHour);
        }
        return null;
    }

    public void addTimeSlot(String date, String timeInterval) {
        this.schedule.put(date, timeInterval);
    }


}