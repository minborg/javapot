package com.blogspot.minborgsjavapot.escape_analysis;

/**
 *
 * @author pemiˆ
 * @param <T0>
 * @param <T1>
 */
public class Tuple2<T0, T1> {

    private final T0 e0;
    private final T1 e1;

    public Tuple2(T0 e0, T1 e1) {
        this.e0 = e0;
        this.e1 = e1;
    }

    @Override
    public String toString() {
        return "(" + e0 + ", " + e1 + ")";
        //return e0.toString();
    }

    public boolean isFirstEqualsSecond() {
        return e0.equals(e1);
    }

}
