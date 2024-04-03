package org.example;
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Destination destination1 = new Destination(faker.address().cityName());
        Destination destination2 = new Destination(faker.address().cityName());

        Person driver1 = new Person(faker.name().fullName(), destination1, true, faker.number().numberBetween(20, 60));
        Person driver2 = new Person(faker.name().fullName(), destination2, true, faker.number().numberBetween(20, 60));

        Person passenger1 = new Person(faker.name().fullName(), destination1, false, faker.number().numberBetween(20, 60));
        Person passenger2 = new Person(faker.name().fullName(), destination2, false, faker.number().numberBetween(20, 60));
        Person passenger3 = new Person(faker.name().fullName(), destination1, false, faker.number().numberBetween(20, 60));


            Person person = new Person(name, destination, isDriver, age);

        carpool.addPerson(driver1);
        carpool.addPerson(driver2);
        carpool.addPerson(passenger1);
        carpool.addPerson(passenger2);
        carpool.addPerson(passenger3);

            iterator.remove();
        }

        System.out.println("Drivers:");
        for (Person driver : drivers) {
            System.out.println(driver.getName());
        }

        System.out.println("Passengers:");
        for (Person passenger : passengers) {
            System.out.println(passenger.getName());
        }

        DestinationInfo destinationInfo = new DestinationInfo();

        List<Destination> driverDestinations = destinationInfo.getDriverDestinations(peopleCopy);
        Map<Destination, List<Person>> destinationPeopleMap = destinationInfo.getDestinationPeopleMap(peopleCopy);

        System.out.println("Driver Destinations:");
        for (Destination destination : driverDestinations) {
            System.out.println(destination.getName());
        }

        System.out.println("Destination People Map:");
        for (Map.Entry<Destination, List<Person>> entry : destinationPeopleMap.entrySet()) {
            System.out.println("Destination: " + entry.getKey().getName());
            System.out.println("People:");
            for (Person person : entry.getValue()) {
                System.out.println(person.getName());
            }
        }
    }
