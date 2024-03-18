package org.example;

public class Person implements Comparable<Person> {
    private String name;
    private Destination destination;
    private boolean isDriver;
    private int age;

    public Person(String name, Destination destination, boolean isDriver, int age) {
        this.name = name;
        this.destination = destination;
        this.isDriver = isDriver;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDriver() {
        return isDriver;
    }


    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
