package com.blogspot.minborgsjavapot.fastmap;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class IntEnumArrayMap<E extends Enum<?>> extends IntArrayMap<E> {

    private static final long serialVersionUID = -2304239764179128L;

    public static <E extends Enum<?>> IntEnumArrayMap<E> fromEnums(final E[] enums, final ToIntFunction<E> function) {
        final int min = Stream.of(enums).mapToInt(function).min().getAsInt();
        final int max = Stream.of(enums).mapToInt(function).max().getAsInt();
        final IntEnumArrayMap<E> result = new IntEnumArrayMap<>(min, max);
        Stream.of(enums).forEach((e) -> result.put(function.applyAsInt(e), e));
        return result;
    }

    public IntEnumArrayMap(int minBound, int maxBound) {
        super(minBound, maxBound);
    }

}
