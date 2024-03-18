package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carpool {
    private List<Person> people;

    public Carpool() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Pair<Person, Person>> matchDriversWithPassengers() {
        List<Person> drivers = people.stream()
                .filter(Person::isDriver)
                .collect(Collectors.toList());

        List<Pair<Person, Person>> matches = new ArrayList<>();
        List<Person> passengersToRemove = new ArrayList<>();

        for (Person driver : drivers) {
            List<Person> passengers = people.stream()
                    .filter(p -> !p.isDriver() && p.getDestination().equals(driver.getDestination()))
                    .collect(Collectors.toList());

            for (Person passenger : passengers) {
                matches.add(new Pair<>(driver, passenger));
                passengersToRemove.add(passenger);
            }
        }

        people.removeAll(passengersToRemove);

        return matches;
    }

    public List<Person> getPeople() {
        return people;
    }
}