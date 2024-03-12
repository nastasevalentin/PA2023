import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Statue statue = new Statue("The Thinker");
        Church church = new Church("Notre Dame");
        Concert concert = new Concert("Rock Concert");
        List<Visitable> attractions = Arrays.asList(statue, church, concert);
        Trip trip = new Trip("Paris", "3 days", attractions);

        System.out.println("Created objects:");
        statue.visit();
        church.visit();
        concert.visit();
    }
}