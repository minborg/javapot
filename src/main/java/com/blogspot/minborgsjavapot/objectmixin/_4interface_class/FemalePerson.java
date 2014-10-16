package com.blogspot.minborgsjavapot.objectmixin._4interface_class;

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

    @Override
    public Object[] members() {
        return exArray(super.members(), getHandbagBrand());
    }

    @Override
    public Object[] names() {
        return exArray(super.names(), "handbagBrand");
    }

    public String getHandbagBrand() {
        return handbagBrand;
    }

    @Override
    public Class<FemalePerson> compareClass() {
        return FemalePerson.class;
    }

}
