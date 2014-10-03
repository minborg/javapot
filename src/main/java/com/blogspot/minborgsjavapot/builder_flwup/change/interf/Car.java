package com.blogspot.minborgsjavapot.builder_flwup.change.interf;



/**
 *
 * @author pemi
 */
public interface Car {

    String getBrand();

    String getType();

    int getPower();

    int getTorque();

    int getGears();

    String getColor();

    static class Hidden {

        protected static class DefaultCar implements Car {

            // Required parameters
            private final String brand;
            private final String type;

            // Optional parameters
            protected int power;
            protected int torque;
            protected int gears;
            protected String color;

            private DefaultCar(String brand, String type) {
                this.brand = brand;
                this.type = type;
            }

            protected DefaultCar(Builder builder) {
                this(builder.getBrand(), builder.getType());
                this.power = builder.power;
                this.torque = builder.torque;
                this.gears = builder.gears;
                this.color = builder.color;
            }

            @Override
            public String getBrand() {
                return brand;
            }

            @Override
            public String getType() {
                return type;
            }

            @Override
            public int getPower() {
                return power;
            }

            @Override
            public int getTorque() {
                return torque;
            }

            @Override
            public int getGears() {
                return gears;
            }

            @Override
            public String getColor() {
                return color;
            }

        }

        private static class ToyotaAvensisCarImpl implements Car {

            private final String color;

            public ToyotaAvensisCarImpl(String color) {
                this.color = color;
            }

            @Override
            public String getBrand() {
                return "Toyota";
            }

            @Override
            public String getType() {
                return "Avensis";
            }

            @Override
            public int getPower() {
                return 108;
            }

            @Override
            public int getTorque() {
                return 180;
            }

            @Override
            public int getGears() {
                return 6;
            }

            @Override
            public String getColor() {
                return color;
            }

        }

        private static Car TOYOTA_AVENSIS_WHITE = new Hidden.ToyotaAvensisCarImpl("White");

    }

    public static class Builder extends Hidden.DefaultCar {

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
            if ("toyota".equalsIgnoreCase(getBrand()) && "Avensis".equalsIgnoreCase(getType())) {
                if ("White".equals(getColor())) {
                    return Hidden.TOYOTA_AVENSIS_WHITE;
                } else {
                    return new Hidden.ToyotaAvensisCarImpl(getColor());
                }
            } else {
                return new Hidden.DefaultCar(this);
            }
        }

    }

}
