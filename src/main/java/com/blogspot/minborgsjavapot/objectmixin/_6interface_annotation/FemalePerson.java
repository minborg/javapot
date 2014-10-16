package com.blogspot.minborgsjavapot.objectmixin._6interface_annotation;

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

    @EqualsAndHashCode
    public String getHandbagBrand() {
        return handbagBrand;
    }

}
