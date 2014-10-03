package com.blogspot.minborgsjavapot.builder._1bean;

/**
 *
 * @author pemi
 */
public class Car {

    // Required parameters
    private final String brand;
    private final String type;

    // Optional parameters
    private int power;
    private int torque;
    private int gears;
    private String color;

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

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
