package com.company;

public class Client extends Human {
    private String bankName;

    public Client(String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Client Name: %s \t Client Surname: %s \t Bank Name: %s \n", super.getName(), super.getSurname(), bankName);
    }

    public void print() {

        System.out.println("This person is client");
    }

}
