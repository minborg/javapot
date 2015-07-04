package com.blogspot.minborgsjavapot.factorials;

import java.util.stream.LongStream;

public class Factorials {

    private Factorials() {
    }

    private static final long[] FACTORIALS = {
        1L,
	1L,
	2L,
	6L,
	24L,
	120L,
	720L,
	5040L,
	40320L,
	362880L,
	3628800L,
	39916800L,
	479001600L,
	6227020800L,
	87178291200L,
	1307674368000L,
	20922789888000L,
	355687428096000L,
	6402373705728000L,
	121645100408832000L,
	2432902008176640000L
    };

    public static long factorial(int n) {
        return FACTORIALS[n];
    }
    
    public static LongStream stream() {
        return LongStream.of(FACTORIALS);
    }

}
