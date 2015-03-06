package com.blogspot.minborgsjavapot.multiple_inherit.generic;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author pemi
 */
public interface Stateful {

    class Hidden {

        // should realy be a ConcurrentWeakIdentityHashMap but you will get the idea anyhow..
        private static final Map<Stateful, Map<String, Object>> map = Collections.synchronizedMap(new WeakIdentityHashMap());

        protected static <T> void set(Stateful s, String name, T val) {
            if (val == null) {
                acquireMap(s).remove(name);
            } else {
                acquireMap(s).put(name, val);
            }
        }

        protected static Map<String, Object> acquireMap(Stateful s) {
            return map.computeIfAbsent(s, $ -> new ConcurrentHashMap<>());
        }

        protected static <T> Optional<T> get(Stateful s, String name) {
            return Optional.ofNullable(map.get(s)).map(m -> (T) m.get(name));
        }

        // Exposed just for tesing
        protected static int size() {
            return map.size();
        }

    }

    default String asString() {
        return getClass().getSimpleName() + " " + Hidden.acquireMap(this);
    }

    default int hash() {
        return Objects.hashCode(Hidden.acquireMap(this));
    }

    default boolean isEqual(Object o) {
        return Optional.ofNullable(o)
                .filter(t -> getClass().isAssignableFrom(t.getClass()))
                .map(t -> (Stateful) t)
                .filter(s -> Hidden.acquireMap(this).equals(Hidden.acquireMap(s)))
                .isPresent();
    }
}
