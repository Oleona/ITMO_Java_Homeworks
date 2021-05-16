package com.company;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        vector test = new vector(3.0,5.0,4.0);
       // System.out.println(test.getX());
        vector vectorX2 = new vector();
        vector test2=new vector(7.0,9.8,7.9);
        System.out.println(" vector length");
       System.out.println(test.getVectorLength());
        System.out.println("the length of the new vector with the given coordinates");
        System.out.println(vectorX2.getVectorLength(2.0,4.1,7.8));
        System.out.println("the length of the new vector, passed as a vector");
        System.out.println(test2.getVectorLength(test2));
        System.out.println("scalar product of multiplication of a vector with a vector given by coordinates");
        System.out.println(test.calculateScalar(7.0,2.0,1.0));
        System.out.println("scalar product of multiplication of a vector with a vector passed as a vector ");
        System.out.println(test.calculateScalar(test2));
        System.out.println("cross product");
        System.out.println(test.getCross(3.0,5.9,6.8));
        System.out.println("angle between vectors");
        System.out.println(test.getAngle(3.1,2.4,3.7));
        System.out.println("sum of two vectors");
        System.out.println(test.getSum(1.0,3.8,6.7));
        System.out.println("difference of two vectors");
        System.out.println(test.getDiff(2.8,8.5,4.8));
        System.out.println("Return array of vectors length N");
        vector.returnArray(0);

    }
}
