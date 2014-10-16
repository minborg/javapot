package com.blogspot.minborgsjavapot.objectmixin._6interface_annotation;

/**
 *
 * @author pemi
 */
public class Person implements Comparable<Person>, AnnotationObjectMixin<Person> {

    private final String name;
    private final String email;
    private final int born;

    public Person(String name, String email, int born) {
        this.name = name;
        this.email = email;
        this.born = born;
    }

    @EqualsAndHashCode
    public String getName() {
        return name;
    }

    @EqualsAndHashCode
    public String getEmail() {
        return email;
    }

    @EqualsAndHashCode
    public int getBorn() {
        return born;
    }

    @Override
    public Comparable<?>[] compareToMembers() {
        return mkComparableArray(getName());
    }

    @Override
    public int hashCode() {
        return _hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return _equals(obj);
    }

    @Override
    public String toString() {
        return _toString();
    }

    @Override
    public int compareTo(Person o) {
        return _compareTo(o);
    }

}
