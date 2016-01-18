package com.blogspot.minborgsjavapot.alternating_interrface_exposure;

/**
 *
 * @author pemi
 */
public class InitialValueBuilder<K> {
    
    private final K k;

    public InitialValueBuilder(K k) {
        this.k = k;
    }
    
    public <V> KeyBuilder<K, V> value(V v) {
        return new Maps<K, V>().key(k).value(v);
    }

}
