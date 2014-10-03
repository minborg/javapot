package com.blogspot.minborgsjavapot.builder._6extend;

public class Main {

    public static void main(String[] args) {
        final ElectricCar tessla = new ElectricCar.Builder("Tessla", "S").power(310).torque(600).gears(1).batteryCapacity(60).build();

        final ElectricCar myNewCar = tessla.toBuilder().color("White").batteryCapacity(85).build();

        System.out.println(myNewCar.getClass().getSimpleName());
        System.out.println(myNewCar.getBrand());
        System.out.println(myNewCar.getType());
        System.out.println(myNewCar.getPower());
        System.out.println(myNewCar.getTorque());
        System.out.println(myNewCar.getGears());
        System.out.println(myNewCar.getColor());
        System.out.println(myNewCar.getBatteryCapacity());

    }

}
