package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class vector {

    private double x;
    private double y;
    private double z;
    static int N=0;

    public vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public vector() {
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    double getVectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getVectorLength(double x2, double y2, double z2) {
        return Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
    }

    double getVectorLength(vector vectorX2) {
        return Math.sqrt(vectorX2.x * vectorX2.x + vectorX2.y * vectorX2.y + vectorX2.z * vectorX2.z);
    }

    // для нашего вектора и произвольного вектора
    double calculateScalar(double x2, double y2, double z2) {
        return x * x2 + y * y2 + z * z2;
    }

    //  для нашего вектора и другого, уже созданнного вектора
    double calculateScalar(vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;

    }

    // для двух созданных векторов
    double calculateScalar(vector vector1, vector vector2) {

        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z;
    }


    vector getCross(double x2, double y2, double z2) {
        double crossX = y * z2 - z * y2;
        double crossY = z * x2 - x * z2;
        double crossZ = x * y2 - y * x2;
        vector vectorResult = new vector(crossX, crossY, crossZ);

        return vectorResult;
    }

    public double getAngle(double x2, double y2, double z2) {
        return calculateScalar(x2, y2, z2) / (Math.abs(getVectorLength()) * Math.abs(getVectorLength(x2, y2, z2)));

    }

    vector getSum(double x2, double y2, double z2){
        vector result= new vector(x+x2,y+y2,z+z2);
        return result;
    }

    vector getDiff(double x2, double y2, double z2){
        vector result= new vector(x-x2,y-y2,z-z2);
        return result;
    }

    @Override
    public String toString() {
        //return String.format(x+ ", " + y + ", " + z);
        return String.format("%.3f , %.3f , %.3f",x,y,z);
    }

    public static void returnArray (int N){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a length of array: ");
        N = scanner.nextInt();
        vector[] vector = new vector[N];
        Random random = new Random();
        for (int i = 0; i <N; i++) {
            vector[i] = new vector(random.nextDouble()*15,random.nextDouble()*15,random.nextDouble()*15);
            System.out.println(Arrays.toString(new vector[]{vector[i]}));
        }



    }


}
