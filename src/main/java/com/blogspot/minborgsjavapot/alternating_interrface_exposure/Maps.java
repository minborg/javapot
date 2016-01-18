package com.blogspot.minborgsjavapot.alternating_interrface_exposure;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author pemi
 */
public class Maps<K, V> implements KeyBuilder<K, V>, ValueBuilder<K, V> {

    private final List<Entry<K, V>> entries;
    private K lastKey;

    public Maps() {
        this.entries = new ArrayList<>();
    }

    @Override
    public ValueBuilder<K, V> key(K k) {
        lastKey = k;
        return (ValueBuilder<K, V>) this;
    }

    @Override
    public KeyBuilder<K, V> value(V v) {
        entries.add(new AbstractMap.SimpleEntry<>(lastKey, v));
        return (KeyBuilder<K, V>) this;
    }

    @Override
    public Map<K, V> build() {
        return entries.stream()
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    public static InitialKeyBuilder builder() {
        return new InitialKeyBuilder();
    }

}
