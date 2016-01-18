package com.blogspot.minborgsjavapot.lazy;

import static java.util.Objects.requireNonNull;
import java.util.function.Supplier;

/**
 *
 * @author pemi
 * @param <T> type
 */
public class Lazy<T> {

    private T value;

    public T getOrCompute(Supplier<T> supplier) {
        return value == null ? maybeCompute(supplier) : value;
    }

    private synchronized T maybeCompute(Supplier<T> supplier) {
        if (value == null) {
            value = requireNonNull(supplier.get());
        }
        return value;
    }

}
