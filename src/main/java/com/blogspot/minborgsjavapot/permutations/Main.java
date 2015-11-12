package com.blogspot.minborgsjavapot.permutations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //final String[] items = {"A", "B", "C"};
        final List<String> items = Arrays.asList("A", "B", "C");
        final long permutations = Permutations.factorial(items.size());
        System.out.println(items + " can be combined in " + permutations + " different ways:");

        LongStream.range(0, permutations).forEachOrdered(i -> {
            System.out.println(i + ": " + Permutations.permutation(i, items));
        });

        Permutations.of("A", "B", "C")
                .map(s -> s.collect(toList()))
                .forEachOrdered(System.out::println);

        Permutations.of("A", "B", "C")
                .flatMap(Function.identity())
                .forEachOrdered(System.out::print);
        System.out.println();

        Permutations.of("A", "B", "C")
                .forEach(Main::printThreadInfo);

        Permutations.of("A", "B", "C")
                .parallel()
                .forEach(Main::printThreadInfo);

        System.out.println(
                Permutations.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
                .findFirst()
                .get()
                .collect(toList())
        );

        Permutations.of(items.toArray()).flatMap(Function.identity()).forEachOrdered(System.out::print);
        System.out.println();

        Runnable setup = () -> System.out.println("setup connection");
        Runnable send = () -> System.out.println("send data");
        Runnable close = () -> System.out.println("close connection");

        Permutations.of(setup, send, close).flatMap(Function.identity()).forEachOrdered(Runnable::run);

        Permutations.of(
                "Get up",
                "Brush teeths",
                "Eat breakfast",
                "Get dressed",
                "Find wallet",
                "Find computer"
        )
                .map(s -> s.collect(toList()))
                .forEach(System.out::println);

        List<String> four = Arrays.asList("A", "B", "C"/*, "D"*/);
        LongStream.range(0, Permutations.factorial(four.size())).forEachOrdered(i -> {
            System.out.println(i + "\t{" + Permutations.permutation(i, four).stream().collect(Collectors.joining(", ")) + "}");
        });

    }

    private static <T> void printThreadInfo(Stream<T> s) {
        System.out.println(Thread.currentThread().getName() + " handles " + s.collect(toList()));
    }

}
