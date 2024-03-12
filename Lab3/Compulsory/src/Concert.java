public class Concert implements Visitable, Payable, Comparable<Concert> {
    private String name;

    public Concert(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.println("Attending the concert: " + this.name);
    }

    @Override
    public void pay() {
        System.out.println("Paid for the concert: " + this.name);
    }

    @Override
    public int compareTo(Concert other) {
        return this.name.compareTo(other.name);
    }
}