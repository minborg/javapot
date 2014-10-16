package com.blogspot.minborgsjavapot.objectmixin._5interface_reflection;

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

}
