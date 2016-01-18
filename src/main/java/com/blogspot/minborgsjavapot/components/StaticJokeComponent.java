package com.blogspot.minborgsjavapot.components;

public class StaticJokeComponent implements JokeComponent {

    @Override
    public String nextJoke() {
        return "I went to buy some camouflage trousers the other day,"
                + " but I couldn’t find any.";
    }

}
