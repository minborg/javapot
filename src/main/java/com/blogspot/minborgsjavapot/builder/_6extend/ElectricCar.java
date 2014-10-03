package com.blogspot.minborgsjavapot.builder._6extend;

public class ElectricCar extends Car {

    private final int batteryCapacity;

    public static class Builder extends Car.Builder {

        private int batteryCapacity;

        public Builder(String brand, String type) {
            super(brand, type);
        }

        public Builder batteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        @Override
        public Builder color(String color) {
            return (Builder) super.color(color);
        }

        @Override
        public Builder gears(int gears) {
            return (Builder) super.gears(gears);
        }

        @Override
        public Builder power(int power) {
            return (Builder) super.power(power);
        }

        @Override
        public Builder torque(int torque) {
            return (Builder) super.torque(torque);
        }

        @Override
        public ElectricCar build() {
            return new ElectricCar(this);
        }

    }

    public ElectricCar(Builder builder) {
        super(builder);
        this.batteryCapacity = builder.batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    protected Builder newBuilder() {
        return new Builder(getBrand(), getType());
    }

    protected Builder decorate(Builder builder) {
        super.decorate(builder);
        return builder.batteryCapacity(getBatteryCapacity());
    }

    @Override
    public Builder toBuilder() {
        return (Builder) super.toBuilder();//decorate(newBuilder());
    }
}
