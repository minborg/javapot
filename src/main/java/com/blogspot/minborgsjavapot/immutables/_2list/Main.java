package com.blogspot.minborgsjavapot.immutables._2list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        final List<String> works = Stream.of("Hamlet", "Othello", "Macbeth").collect(Collectors.toList());
        final Author author = new Author("William Shakespeare", 1564, works);
        println(author);

        // NOT GOOD! We can add things to the list after the object is created!
        author.getWorks().add("Harry Potter");
        println(author);
    }

    private static void println(final Author author) {
        System.out.println(author.getName() + " was born in " + author.getBornYear()
                + " and wrote " + author.getWorks().stream().collect(Collectors.joining(", ")));
    }

}
