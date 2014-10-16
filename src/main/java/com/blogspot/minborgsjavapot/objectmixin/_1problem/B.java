package com.blogspot.minborgsjavapot.objectmixin._1problem;

public class B extends A {

    private final int anotherValue;

    public B(int val, int anotherValue) {
        super(val);
        this.anotherValue = anotherValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.getValue();
        hash = 67 * hash + this.getAnotherValue();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        final B other = (B) obj;
        if (this.getAnotherValue() != other.getAnotherValue()) {
            return false;
        }
        if (this.getValue() != other.getValue()) {
            return false;
        }
        return true;
    }

    public int getAnotherValue() {
        return anotherValue;
    }

}
