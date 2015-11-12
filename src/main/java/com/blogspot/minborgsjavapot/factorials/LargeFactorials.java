package com.blogspot.minborgsjavapot.factorials;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LargeFactorials {

    public static BigInteger factorial(int n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(l -> BigInteger.valueOf(l))
                .reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
    }

    public static Stream<BigInteger> stream() {
        // Only iterates over 2³31 objects
        return IntStream.iterate(0, (i) -> i + 1)
                .mapToObj(LargeFactorials::factorial);
    }

    private static final int FACTORIAL_LOOKUP_SIZE = 100; // Must be at least 2;
    private static final BigInteger[] FACTORIAL_LOOKUP = new BigInteger[FACTORIAL_LOOKUP_SIZE];

    static {
        IntStream.range(0, FACTORIAL_LOOKUP_SIZE).forEach(i -> {
            FACTORIAL_LOOKUP[i] = factorial(i);
        });
    }

    public static BigInteger fastFactorial(int n) {
        if (n > FACTORIAL_LOOKUP_SIZE) {
            return FACTORIAL_LOOKUP[n];
        }
        return LongStream.rangeClosed(FACTORIAL_LOOKUP_SIZE, n)
                .mapToObj(l -> BigInteger.valueOf(l))
                .reduce(FACTORIAL_LOOKUP[FACTORIAL_LOOKUP_SIZE - 1], (a, b) -> a.multiply(b));
    }

    public static Stream<BigInteger> fastStream() {
        return StreamSupport.stream(new FactorialIterable().spliterator(), false);
    }

    private static class FactorialIterable implements Iterator<BigInteger>, Iterable<BigInteger> {

        private BigInteger value = BigInteger.ONE;
        private BigInteger iteration = BigInteger.ZERO;

        @Override
        public Iterator<BigInteger> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public BigInteger next() {
            if (BigInteger.ZERO.equals(iteration)) {
                iteration = iteration.add(BigInteger.ONE);
                return value;
            }
            value = value.multiply(iteration);
            iteration = iteration.add(BigInteger.ONE);
            return value;
        }

    }

}
