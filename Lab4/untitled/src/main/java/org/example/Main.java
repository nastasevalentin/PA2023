package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Destination destination1 = new Destination("Destination 1");
        Destination destination2 = new Destination("Destination 2");

        Person driver1 = new Person("Driver 1", destination1, true, 23);
        Person driver2 = new Person("Driver 2", destination2, true, 35);

        Person passenger1 = new Person("Passenger 1", destination1, false, 46);
        Person passenger2 = new Person("Passenger 2", destination2, false, 39);

        Carpool carpool = new Carpool();

        carpool.addPerson(driver1);
        carpool.addPerson(driver2);
        carpool.addPerson(passenger1);
        carpool.addPerson(passenger2);

        List<Person> peopleCopy = new ArrayList<>(carpool.getPeople());

        List<Pair<Person, Person>> matches = carpool.matchDriversWithPassengers();

        for (Pair<Person, Person> match : matches) {
            System.out.println(match.getFirst().getName() + " is matched with " + match.getSecond().getName());
        }

        LinkedList<Person> drivers = peopleCopy.stream()
                .filter(Person::isDriver)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Person> passengers = peopleCopy.stream()
                .filter(p -> !p.isDriver())
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Drivers sorted by age:");
        for (Person driver : drivers) {
            System.out.println(driver.getName() + ", " + driver.getAge());
        }

        System.out.println("Passengers sorted by name:");
        for (Person passenger : passengers) {
            System.out.println(passenger.getName());
        }
    }
}