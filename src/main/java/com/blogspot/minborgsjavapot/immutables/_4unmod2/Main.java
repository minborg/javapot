package com.blogspot.minborgsjavapot.immutables._4unmod2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        final List<String> works = Stream.of("Hamlet", "Othello", "Macbeth").collect(Collectors.toList());
        final Author author = new Author("William Shakespeare", 1564, works);
        println(author);

        // We failed again because we can modify the works List 
        // and it reflects in the Author after creation
        works.add("Harry Potter");
        println(author);
        
        // This works though!
        author.getWorks().add("Harry Potter 2");
        
    }

    private static void println(final Author author) {
        System.out.println(author.getName() + " was born in " + author.getBornYear()
                + " and wrote " + author.getWorks().stream().collect(Collectors.joining(", ")));
    }

}
