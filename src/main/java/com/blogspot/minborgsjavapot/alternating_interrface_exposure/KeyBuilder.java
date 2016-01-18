package com.blogspot.minborgsjavapot.alternating_interrface_exposure;

import java.util.Map;

/**
 *
 * @author pemi
 */
public interface KeyBuilder<K, V> {

        ValueBuilder<K, V> key(K k);
        
        Map<K, V> build();
    
}
