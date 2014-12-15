package com.blogspot.minborgsjavapot.fastmap;

public class ShortArrayMap<V> extends NumberArrayMap<Short, V> {

    private static final long serialVersionUID = -2304239764179125L;
    
    public ShortArrayMap(short minBound, short maxBound) {
        super(minBound, maxBound);
    }

    @Override
    protected Short makeKeyFromInt(int k) {
        return (short)k;
    }

}
