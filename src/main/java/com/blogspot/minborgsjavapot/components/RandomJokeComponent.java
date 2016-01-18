package com.blogspot.minborgsjavapot.components;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomJokeComponent implements JokeComponent {

    private final Random random = new Random();
    private final List<String> jokes = Arrays.asList(
            "What's blue and doesn't weigh much? Light blue.",
            "A dyslexic man walks into a bra.",
            "What do you call a fish with no eyes? A fsh."
    );

    @Override
    public String nextJoke() {
        return jokes.get(random.nextInt(jokes.size()));
    }

}
