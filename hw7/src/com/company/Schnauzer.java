package com.company;

public class Schnauzer extends Dog{




    @Override
    public void GetParams() {
        System.out.println("Input dog name ");
        String name=scanner.next();
        System.out.println("Our dog name is "+ name );
    }


}
