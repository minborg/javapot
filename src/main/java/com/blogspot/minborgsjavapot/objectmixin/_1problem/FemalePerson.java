package com.blogspot.minborgsjavapot.objectmixin._1problem;

import java.util.Objects;

/**
 *
 * @author pemi
 */
public class FemalePerson extends Person {

    private final String handbagBrand;

    public FemalePerson(String handbagBrand, String name, String email, int born) {
        super(name, email, born);
        this.handbagBrand = handbagBrand;
    }

    public String getHandbagBrand() {
        return handbagBrand;
    }

    @Override
    public int hashCode() {
        return 61 * super.hashCode() + Objects.hashCode(getHandbagBrand());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final FemalePerson other = (FemalePerson) obj;
        if (!Objects.equals(this.getHandbagBrand(), other.getHandbagBrand())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FemalePerson{" + "Name=" + getName() + ", Email=" + getEmail() + ", Born=" + getBorn() + ", HandbagBrand=" + getHandbagBrand() + '}';
    }

}
