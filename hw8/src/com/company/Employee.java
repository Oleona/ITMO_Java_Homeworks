package com.company;

public class Employee extends Human {

    private String bankName;

    public Employee(String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Employee Name: %s \t Employee Surname: %s \t Bank Name: %s \n", super.getName(), super.getSurname(), bankName);
    }

    public void print() {

        System.out.println("This person is employee");
    }
}
