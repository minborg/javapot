package com.blogspot.minborgsjavapot.objectmixin._1problem;

public class A {

    private final int value;

    public A(int val) {
        this.value = val;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.getValue();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        final A other = (A) obj;
        if (this.getValue() != other.getValue()) {
            return false;
        }
        return true;
    }

    public int getValue() {
        return value;
    }

}
