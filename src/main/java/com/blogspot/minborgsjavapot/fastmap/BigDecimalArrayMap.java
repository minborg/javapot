package com.blogspot.minborgsjavapot.fastmap;

import java.math.BigDecimal;

/**
 * 
 * @author pemi
 * @param <V>
 * @deprecated because 3.1 and 3.2 will point to the same key
 */

@Deprecated
public class BigDecimalArrayMap<V> extends NumberArrayMap<BigDecimal, V> {

    private static final long serialVersionUID = -2304239764179128L;

    public BigDecimalArrayMap(int minBound, int maxBound) {
        super(minBound, maxBound);
    }

    @Override
    protected BigDecimal makeKeyFromInt(int k) {
        return new BigDecimal(k);
    }

}
