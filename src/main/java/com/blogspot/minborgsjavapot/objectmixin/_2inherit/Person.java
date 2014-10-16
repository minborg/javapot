package com.blogspot.minborgsjavapot.objectmixin._2inherit;

/**
 *
 * @author pemi
 */
public class Person extends AbstractObjectSupport<Person> {

    private final String name;
    private final String email;
    private final int born;

    public Person(String name, String email, int born) {
        this.name = name;
        this.email = email;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getBorn() {
        return born;
    }

    @Override
    public Object[] members() {
        return mkArray(getName(), getEmail(), getBorn());
    }

    @Override
    public Object[] names() {
        return mkArray("Name", "Email", "Born");
    }

    @Override
    public Comparable<?>[] compareToMembers() {
        return mkComparableArray(getName());
    }

}
