package com.blogspot.minborgsjavapot.builder._4change;

public class Main {

    public static void main(String[] args) {

        final Car toyota = new Car.Builder("Toyota", "Avensis").power(108).torque(180).gears(6).build();

        final Car myNewCar = toyota.toBuilder().color("Black").build();

    }

}
