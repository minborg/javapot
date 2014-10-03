package com.blogspot.minborgsjavapot.builder_flwup.change.interf;



public class Main {

    public static void main(String[] args) {
        final Car toyota = new Car.Builder("Toyota", "Avensis").power(108).torque(180).gears(6).build();
        final Car toyotaWhite = new Car.Builder("Toyota", "Avensis").power(108).torque(180).gears(6).color("White").build();

        System.out.println(toyota);
        System.out.println(toyotaWhite);
    }

}
