public class Statue implements Visitable, Payable, Comparable<Statue> {
    private String name;

    public Statue(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.println("Visiting the statue: " + this.name);
    }

    @Override
    public void pay() {
        System.out.println("Statues are usually free to visit.");
    }

    @Override
    public int compareTo(Statue other) {
        return this.name.compareTo(other.name);
    }
}