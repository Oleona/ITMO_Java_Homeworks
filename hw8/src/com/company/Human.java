package com.company;

public abstract class Human implements Printable {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public abstract void displayInfo();

    public Human(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }
}
