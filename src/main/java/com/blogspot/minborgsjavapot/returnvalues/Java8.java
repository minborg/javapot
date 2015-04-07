package com.blogspot.minborgsjavapot.returnvalues;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.collectingAndThen;
import java.util.stream.Stream;

/**
 *
 * @author pemi
 */
public class Java8 {

    public String poemStream() {
        return Stream.of("Hey there my dearest baby small, ", "soon you will be big and tall")
                .collect(joining());
    }

    public String poem() {
        return with(StringBuilder::new,
                sb -> sb
                .append("Hey there my dearest baby small, ")
                .append("soon you will be big and tall"),
                StringBuilder::toString);
    }

    public Set<String> suits() {
        return with(HashSet<String>::new, s -> {
            s.add("Hearts");
            s.add("Spades");
            s.add("Diamonds");
            s.add("Clubs");
        }, Collections::unmodifiableSet);
    }

    public Set<String> suitsMutable() {
        return with(HashSet<String>::new, s -> {
            s.add("Hearts");
            s.add("Spades");
            s.add("Diamonds");
            s.add("Clubs");
        }, Function.identity());
    }

    public Set<String> suitsStream() {
        return Collections.unmodifiableSet(
                Stream.of("Hearts", "Spades", "Diamonds", "Clubs")
                .collect(toSet()));
    }

    public <T, R> R with(Supplier<T> supplier, Consumer<T> mutator, Function<T, R> finisher) {
        final T start = supplier.get();
        mutator.accept(start);
        return finisher.apply(start);
    }

    public <T> T with(Supplier<T> supplier, Consumer<T> mutator) {
        final T start = supplier.get();
        mutator.accept(start);
        return start;
    }

    public Set<String> suitsStreamAndCollect() {
        return Stream.of("Hearts", "Spades", "Diamonds", "Clubs")
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
    }
    
    public <T> Set<T> immutableSetOf(T... members) {
        return Stream.of(members)
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
    }

    
    public Set<String> suitsSimple() {
        return immutableSetOf("Hearts", "Spades", "Diamonds", "Clubs");
    }

    
}
