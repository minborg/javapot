package com.blogspot.minborgsjavapot.multiple_inherit.generic;

/**
 *
 * @author pemi
 */
public class DefaultStateful implements Stateful {

    @Override
    public String toString() {
        return Stateful.super.asString();
    }

    @Override
    public int hashCode() {
        return Stateful.super.hash();
    }

    @Override
    public boolean equals(Object obj) {
        return Stateful.super.isEqual(obj);
    }

}
