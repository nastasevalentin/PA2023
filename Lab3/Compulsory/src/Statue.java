public class Statue implements Visitable, Payable, Comparable<Statue> {
    private String name;
    private double price;

    public Statue(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Timetable getTimetable() {
        return null;
    }

    @Override
    public void visit() {
        System.out.println("Visiting the statue: " + this.name);
    }

    @Override
    public void pay() {
        if (this.price == 0) {
            System.out.println(this.name + " is free to visit.");
        } else {
            System.out.println("Paying the entrance fee for the statue: " + this.price);
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Statue other) {
        return this.name.compareTo(other.name);
    }
}