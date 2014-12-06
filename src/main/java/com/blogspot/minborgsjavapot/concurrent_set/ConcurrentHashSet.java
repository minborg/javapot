package com.blogspot.minborgsjavapot.concurrent_set;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A hash set supporting full concurrency of retrievals and
 * high expected concurrency for updates.
 * 
 * @param <E> the type of elements maintained by this set
 * @author pemi
 */
public class ConcurrentHashSet<E> implements ConcurrentSet<E>, Serializable {

    private final ConcurrentMap<E, Object> m;
    private transient Set<E> s;

    public ConcurrentHashSet() {
        this.m = new ConcurrentHashMap<>();
        init();
    }

    public ConcurrentHashSet(int initialCapacity) {
        this.m = new ConcurrentHashMap<>(initialCapacity);
        init();
    }

    public ConcurrentHashSet(int initialCapacity, float loadFactor) {
        this.m = new ConcurrentHashMap<>(initialCapacity, loadFactor);
        init();
    }

    public ConcurrentHashSet(int initialCapacity, float loadFactor, int concurrencyLevel) {
        this.m = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);
        init();
    }

    public ConcurrentHashSet(Set<? extends E> s) {
        this(Math.max(Objects.requireNonNull(s).size(), 16));
        addAll(s);
    }
    
    public ConcurrentHashSet(Supplier<? extends ConcurrentMap<E, Object>> concurrentMapSupplier) {
        final ConcurrentMap<E, Object> newMap = concurrentMapSupplier.get();
        if (!(newMap instanceof ConcurrentMap)) {
            throw new IllegalArgumentException("The supplied map does not implement "+ConcurrentMap.class.getSimpleName());
        }
        this.m = newMap;
        init();
    }
    
    private void init() {
        this.s = m.keySet();
    }
    
    @Override public void clear()               {        m.clear(); }
    @Override public int size()                 { return m.size(); }
    @Override public boolean isEmpty()          { return m.isEmpty(); }
    @Override public boolean contains(Object o) { return m.containsKey(o); }
    @Override public boolean remove(Object o)   { return m.remove(o) != null; }
    @Override public boolean add(E e)           { return m.put(e, Boolean.TRUE) == null; }
    @Override public Iterator<E> iterator()     { return s.iterator(); }
    @Override public Object[] toArray()         { return s.toArray(); }
    @Override public <T> T[] toArray(T[] a)     { return s.toArray(a); }
    @Override public String toString()          { return s.toString(); }
    @Override public int hashCode()             { return s.hashCode(); }
    @Override public boolean equals(Object o)   { return s.equals(o); }
    @Override public boolean containsAll(Collection<?> c) {return s.containsAll(c);}
    @Override public boolean removeAll(Collection<?> c)   {return s.removeAll(c);}
    @Override public boolean retainAll(Collection<?> c)   {return s.retainAll(c);}

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return Objects.requireNonNull(c).stream().map((e) -> add(e)).filter((b)->b).count() > 0;
    }

    // Override default methods in Collection
    @Override public void forEach(Consumer<? super E> action) { s.forEach(action);}
    @Override public boolean removeIf(Predicate<? super E> filter) { return s.removeIf(filter);}
    @Override public Spliterator<E> spliterator()     {return s.spliterator();}
    @Override public Stream<E> stream()               {return s.stream();}
    @Override public Stream<E> parallelStream()       {return s.parallelStream();}

    private static final long serialVersionUID = -913526372691027123L;

    private void readObject(java.io.ObjectInputStream stream)
       throws IOException, ClassNotFoundException
    {
        stream.defaultReadObject();
        init();
    }

}
