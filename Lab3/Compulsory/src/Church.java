public class Church implements Visitable, Payable, Comparable<Church> {
    private String name;
    private Timetable timetable;
    private double price;

    public Church(String name, double price) {
        this.name = name;
        this.timetable = new Timetable();
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Timetable getTimetable() {
        return this.timetable;
    }

    @Override
    public void visit() {
        System.out.println("Visiting the church: " + this.name);
    }

    @Override
    public void pay() {
        if (this.price == 0) {
            System.out.println(this.name + " is free to visit.");
        } else {
            System.out.println("Paying the entrance fee for the church: " + this.price);
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Church other) {
        return this.name.compareTo(other.name);
    }
}