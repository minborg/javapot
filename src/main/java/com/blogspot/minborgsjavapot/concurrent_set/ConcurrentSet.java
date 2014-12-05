package com.blogspot.minborgsjavapot.concurrent_set;

import java.util.Set;

/**
 *
 * @author pemi
 * @param <E> the type of elements maintained by this set
 *
 * @see Set
 */
public interface ConcurrentSet<E> extends Set<E> {

    /**
     * If the specified element is not already added to the Set, associate it
     * with the given value. This is equivalent to
     * <pre> {@code
     * if (!set.contains(e))
     *   set.add(e);
     *   return true;
     * else
     *   return false;
     * }</pre>
     *
     * except that the action is performed atomically.
     *
     *
     * @param e element to be added to the set, if not previously present
     * @return the previous value associated with the specified key, or
     * {@code null} if there was no mapping for the key. (A {@code null} return
     * can also indicate that the map previously associated {@code null} with
     * the key, if the implementation supports null values.)
     * @throws UnsupportedOperationException if the {@code add} operation is not
     * supported by this set
     * @throws ClassCastException if the class of the specified element prevents
     * it from being stored in this set
     * @throws NullPointerException if the specified element is null, and this
     * set does not permit null elements
     * @throws IllegalArgumentException if some property of the specified
     * element prevents it from being stored in this set
     */
    boolean addIfAbsent(E e);

}
