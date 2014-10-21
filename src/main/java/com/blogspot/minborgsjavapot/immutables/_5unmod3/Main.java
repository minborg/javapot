package com.blogspot.minborgsjavapot.immutables._5unmod3;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        final List<String> works = Stream.of("Hamlet", "Othello", "Macbeth").collect(Collectors.toList());
        final Author author = new Author("William Shakespeare", 1564, works);
        println(author);

        // Will not affect the Author because it holds its own copy
        works.add("Harry Potter");
        println(author);

        // Will throw an UnsupportedOperationException 
        author.getWorks().add("Harry Potter"); 
        println(author);
    }

    private static void println(final Author author) {
        System.out.println(author.getName() + " was born in " + author.getBornYear()
                + " and wrote " + author.getWorks().stream().collect(Collectors.joining(", ")));
    }

}
