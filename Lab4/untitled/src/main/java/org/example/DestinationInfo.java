package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DestinationInfo {

    public List<Destination> getDriverDestinations(List<Person> people) {
        return people.stream()
                .filter(Person::isDriver)
                .map(Person::getDestination)
                .collect(Collectors.toList());
    }

    public Map<Destination, List<Person>> getDestinationPeopleMap(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getDestination));
    }
}