package com.blogspot.minborgsjavapot.alternating_interrface_exposure;

/**
 *
 * @author pemi
 */
public interface ValueBuilder<K, V> {

    KeyBuilder<K, V> value(V v);

}
