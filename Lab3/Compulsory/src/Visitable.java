import java.time.LocalTime;

public interface Visitable {
    void visit();
    Timetable getTimetable();
    String getName();

    default LocalTime getOpeningHour(String date) {
        return getTimetable().getOpeningHour(date);
    }
}