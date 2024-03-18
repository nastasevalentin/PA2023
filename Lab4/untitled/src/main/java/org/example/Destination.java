package org.example;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Person> people;

    public Destination(String name) {
        this.name = name;
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
