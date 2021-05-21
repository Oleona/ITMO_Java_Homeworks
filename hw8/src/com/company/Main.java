package com.company;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee("Ivan", "Ivanov", "VTB");
        employee.displayInfo();
        employee.print();
        Client client = new Client("Petr", "Petrov", "VTB");
        client.displayInfo();
        client.print();
    }
}
