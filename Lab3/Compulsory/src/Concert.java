public class Concert implements Visitable, Payable, Comparable<Concert> {
    private String name;
    private Timetable timetable;
    private double price;

    public Concert(String name, double price) {
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
        System.out.println("Attending the concert: " + this.name);
    }

    @Override
    public void pay() {
        if (this.price == 0) {
            System.out.println(this.name + " is free to attend.");
        } else {
            System.out.println("Paying the entrance fee for the concert: " + this.price);
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Concert other) {
        return this.name.compareTo(other.name);
    }
}