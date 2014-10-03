package com.blogspot.minborgsjavapot.builder._2telescope;

/**
 *
 * @author pemi
 */
public class Car {

    // Required parameters
    private final String brand;
    private final String type;

    // Optional parameters
    private final int power;
    private final int torque;
    private final int gears;
    private final String color;

    public Car(String brand, String type, int power, int torque, int gears, String color) {
        this.brand = brand;
        this.type = type;
        this.power = power;
        this.torque = torque;
        this.gears = gears;
        this.color = color;
    }

    public Car(String brand, String type) {
        this(brand, type, 0, 0, 0, null);
    }

    public Car(String brand, String type, int power) {
        this(brand, type, power, 0, 0, null);
    }

    public Car(String brand, String type, int power, int torque) {
        this(brand, type, power, torque, 0, null);
    }

    public Car(String brand, String type, int power, int torque, int gears) {
        this(brand, type, power, torque, gears, null);
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public int getTorque() {
        return torque;
    }

    public int getGears() {
        return gears;
    }

    public String getColor() {
        return color;
    }

}
