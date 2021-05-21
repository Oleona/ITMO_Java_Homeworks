package com.company;

public class Plane {
    public void getPlaneWithWing(int wingweight) {
        Wing wing = new Wing();
        wing.setWeight(wingweight);
        wing.getWingWeight();
    }


     public class Wing {
        private int weight;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Wing() {
        }

        public void getWingWeight() {
            System.out.println("This wing weight is: " + weight);
        }

    }
}