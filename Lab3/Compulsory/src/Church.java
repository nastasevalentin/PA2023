public class Church implements Visitable, Payable, Comparable<Church> {
    private String name;

    public Church(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.println("Visiting the church: " + this.name);
    }

    @Override
    public void pay() {
        System.out.println("Made a donation at the church: " + this.name);
    }

    @Override
    public int compareTo(Church other) {
        return this.name.compareTo(other.name);
    }
}