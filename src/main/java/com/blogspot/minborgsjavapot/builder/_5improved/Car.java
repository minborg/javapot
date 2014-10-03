package com.blogspot.minborgsjavapot.builder._5improved;

/**
 *
 * @author pemi
 */
public class Car {

    // Required parameters
    protected final String brand;
    protected final String type;

    // Optional parameters
    protected int power;
    protected int torque;
    protected int gears;
    protected String color;

    private Car(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }
    
    public static class Builder extends Car {

        public Builder(String brand, String type) {
            super(brand, type);
        }

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder torque(int torque) {
            this.torque = torque;
            return this;
        }

        public Builder gears(int gears) {
            this.gears = gears;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

    protected Car(Builder builder) {
        this.brand = builder.brand;
        this.type = builder.type;
        this.power = builder.power;
        this.torque = builder.torque;
        this.gears = builder.gears;
        this.color = builder.color;
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
