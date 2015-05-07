package com.blogspot.minborgsjavapot.pojo;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {
        // Use a constructor with parameters to create a City
        City sf = new City("San Francisco", "SF");

        // Use a default constructor with no parameters to create a City
        City la = new City();
        // Set the members using setters
        la.setName("Los Angeles");
        la.setCode("LA");

        // What is a getter?
        // Use the City's method references and assign them to functions
        Function<City, String> getNameFunction = City::getName;
        Function<City, String> getCodeFunction = City::getCode;

        System.out.println("The code for "
                + getNameFunction.apply(sf)
                + " is "
                + getCodeFunction.apply(sf));

        // What is a setter?
        // Use the City's method references and assign them to biconsumers
        BiConsumer<City, String> setNameBiConsumer = City::setName;
        BiConsumer<City, String> setCodeBiConsumer = City::setCode;

        City ny = new City();
        setNameBiConsumer.accept(ny, "New York");
        setCodeBiConsumer.accept(ny, "NY");

        // What is a constructor
        // Use the City's constructor method reference to create
        // a default constructor reference.
        Supplier<City> defaultConstructor = City::new;

        City sd = defaultConstructor.get();
        sd.setName("San Diego");
        sd.setCode("SD");

        // Use the City's constructor method reference to create
        // a two parameter constructor reference.
        BiFunction<String, String, City> twoParameterConstructor = City::new;

        City dc = twoParameterConstructor.apply("Washington, D.C.", "DC");

    }

}
