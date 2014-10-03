package com.blogspot.minborgsjavapot.builder._3builder;

public class Main {

    public static void main(String[] args) {
        final Car toyota = new Car.Builder("Toyota", "Avensis").power(108).torque(180).gears(6).build();
    }

}
