package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    public static void main(String[] args) {
        Parking parking = new Parking(4);
        System.out.print(parking.arrive(2) + " ");
        System.out.print(parking.arrive(3) + " ");
        System.out.print(parking.arrive(2) + " ");
        System.out.print(parking.arrive(2) + " ");
        System.out.print(parking.arrive(2) + " ");
        System.out.print(parking.depart(1) + " ");
        System.out.print(parking.depart(1) + " ");
        parking.print();
        System.out.print("\n");
    }

}
