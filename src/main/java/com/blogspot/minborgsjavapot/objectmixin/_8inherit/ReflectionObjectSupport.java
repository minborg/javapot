package com.blogspot.minborgsjavapot.objectmixin._8inherit;

import com.blogspot.minborgsjavapot.objectmixin._7interface_reflection.performance.ReflectionObjectMixin;

public class ReflectionObjectSupport<T extends ReflectionObjectMixin<T>> implements ReflectionObjectMixin<T>, Comparable<T> {

    @Override
    public Comparable<?>[] compareToMembers() {
        throw new UnsupportedOperationException("Override this method in your class to implement comapreTo() support.");
    }

    @Override
    public boolean equals(Object obj) {
        return _equals(obj);
    }

    @Override
    public int hashCode() {
        return _hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return _toString();
    }

    @Override
    public int compareTo(T o) {
        return _compareTo(o);
    }

}
