package com.blogspot.minborgsjavapot.map_init;

import static com.blogspot.minborgsjavapot.map_init.Maps.entriesToMap;
import static com.blogspot.minborgsjavapot.map_init.Maps.entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {

        final Map<Integer, String> map = imperative();
        System.out.println("There are " + toText(map, 2) + " birds and " + toText(map, 21) + " flowers.");

    }

    public static String toText(Map<Integer, String> map, int val) {
        return map.getOrDefault(val, Integer.toString(val));
    }

    protected static Map<Integer, String> imperative() {
        final Map<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "zero");
        numMap.put(1, "one");
        numMap.put(2, "two");
        numMap.put(3, "three");
        numMap.put(4, "four");
        numMap.put(5, "five");
        numMap.put(6, "six");
        numMap.put(7, "seven");
        numMap.put(8, "eight");
        numMap.put(9, "nine");
        numMap.put(10, "ten");
        numMap.put(11, "eleven");
        numMap.put(12, "twelve");
        return Collections.unmodifiableMap(numMap);
    }

    // reference to this$0
    // instanceof problem
    // supress warning
    // Can not infere types using diamond <>
    // Creates an additional class
    @SuppressWarnings("serial")
    protected static Map<Integer, String> doubleBracket() {

        return Collections.unmodifiableMap(new HashMap<Integer, String>() {
            {
                put(0, "zero");
                put(1, "one");
                put(2, "two");
                put(3, "three");
                put(4, "four");
                put(5, "five");
                put(6, "six");
                put(7, "seven");
                put(8, "eight");
                put(9, "nine");
                put(10, "ten");
                put(11, "eleven");
                put(12, "twelve");
            }
        });
    }

    protected static Map<Integer, String> builderPattern() {
        return Maps.<Integer, String>builder().
                put(0, "zero").
                put(1, "one").
                put(2, "two").
                put(3, "three").
                put(4, "four").
                put(5, "five").
                put(6, "six").
                put(7, "seven").
                put(8, "eight").
                put(9, "nine").
                put(10, "ten").
                put(11, "eleven").
                put(12, "twelve").
                unmodifiable(true).
                build();
    }

    protected static ConcurrentMap<Integer, String> concurrentBuilder() {
        return Maps.<Integer, String>concurrentBuilder().
                put(0, "zero").
                put(1, "one").
                put(2, "two").
                put(3, "three").
                put(4, "four").
                put(5, "five").
                put(6, "six").
                put(7, "seven").
                put(8, "eight").
                put(9, "nine").
                put(10, "ten").
                put(11, "eleven").
                put(12, "twelve").
                build(); // Note: Not unmodifiable but it makes not much sense to have an unmodifiable concurrent map, would it?
    }

    protected static Map<Integer, String> stdJava8() {

        return Collections.unmodifiableMap(Stream.of(
                new SimpleEntry<>(0, "zero"),
                new SimpleEntry<>(1, "one"),
                new SimpleEntry<>(2, "two"),
                new SimpleEntry<>(3, "three"),
                new SimpleEntry<>(4, "four"),
                new SimpleEntry<>(5, "five"),
                new SimpleEntry<>(6, "six"),
                new SimpleEntry<>(7, "seven"),
                new SimpleEntry<>(8, "eight"),
                new SimpleEntry<>(9, "nine"),
                new SimpleEntry<>(10, "ten"),
                new SimpleEntry<>(11, "eleven"),
                new SimpleEntry<>(12, "twelve"))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
    }

    protected static Map<Integer, String> extJava8() {
        return Collections.unmodifiableMap(Stream.of(
                entry(0, "zero"),
                entry(1, "one"),
                entry(2, "two"),
                entry(3, "three"),
                entry(4, "four"),
                entry(5, "five"),
                entry(6, "six"),
                entry(7, "seven"),
                entry(8, "eight"),
                entry(9, "nine"),
                entry(10, "ten"),
                entry(11, "eleven"),
                entry(12, "twelve")).
                collect(entriesToMap()));
    }

}
