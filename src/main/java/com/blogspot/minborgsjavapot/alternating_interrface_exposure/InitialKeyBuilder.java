package com.blogspot.minborgsjavapot.alternating_interrface_exposure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pemi
 */
public class InitialKeyBuilder {

    public <K> InitialValueBuilder<K> key(K k) {
        return new InitialValueBuilder<>(k);
    }
    
    public <K, V> Map<K, V> build() {
        return new HashMap<>();
    }

}
