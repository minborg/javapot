/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.minborgsjavapot.components;

import java.util.stream.IntStream;

/**
 *
 * @author pemi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ClassMapper componentHandler = new ClassMapperImpl();
        setupComponents(componentHandler);

        crankOutTenJokes(componentHandler);
    }

    private static void setupComponents(ClassMapper componentHandler) {
        // Plug in the selected basic JokeGenerator
        componentHandler.put(JokeComponent.class, new RandomJokeComponent());
    }

    private static void crankOutTenJokes(ClassMapper componentHandler) {
        // Get the current JokeGenerator that is plugged into the componentHandler
        JokeComponent jokeGenerator = componentHandler.get(JokeComponent.class);
        // Tell the world who is making the jokes
        System.out.println(jokeGenerator.getClass().getSimpleName() + " says:");
        // print ten of its joke
        IntStream.rangeClosed(1, 10)
                .mapToObj(i -> jokeGenerator.nextJoke())
                .forEach(System.out::println);
    }

}
