package com.company;

import java.util.Calendar;

public class Home {
    private int numberFloors;
    private int constructionYear;
    private String name;


    public int getNumberFloors(int numberFloors) {
        return this.numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public int getConstructionYear(int constructionYear) {
        return this.constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllValues(int numberFloors, int constructionYear, String name) {
        this.numberFloors = numberFloors;
        this.constructionYear = constructionYear;
        this.name = name;
    }
    public void showAllValues() {
        System.out.printf("number of floors: %d\tconstruction year: %d\tName: %s\n",getNumberFloors(numberFloors),getConstructionYear(constructionYear),getName(name));
    }

    public int countAge(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return (year-this.constructionYear);
    }

}
