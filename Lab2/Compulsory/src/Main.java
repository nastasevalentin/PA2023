public class Main {
    public static void main(String[] args) {
        Location c1 = new Location();
        c1.setName("Iasi");
        c1.setX(0.0);
        c1.setY(0.0);
        System.out.println(c1);

        Location c2 = new Location("Vaslui", 10.0, 20.0, LocationType.CITY);
        System.out.println(c2);

        Road iasiVasluiRoad = new Road(RoadType.EXPRESS, 20, 60);
        System.out.println(iasiVasluiRoad);
    }
}