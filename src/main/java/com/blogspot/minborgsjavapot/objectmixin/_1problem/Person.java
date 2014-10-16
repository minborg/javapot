package com.blogspot.minborgsjavapot.objectmixin._1problem;

import java.util.Objects;

/**
 *
 * @author pemi
 */
public class Person implements Comparable<Person> {

    private final String name;
    private final String email;
    private final int born;

    public Person(String name, String email, int born) {
        this.name = Objects.requireNonNull(name);
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
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(getName());
        hash = 61 * hash + Objects.hashCode(getEmail());
        hash = 61 * hash + getBorn();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(this.getEmail(), other.getEmail())) {
            return false;
        }
        if (this.getBorn() != other.getBorn()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "Name=" + getName() + ", Email=" + getEmail() + ", Born=" + getBorn() + '}';
    }

    @Override
    public int compareTo(Person that) {
        int nameCompareTo = this.getName().compareTo(that.getName());
        if (nameCompareTo != 0) {
            return nameCompareTo;
        }
        return Integer.valueOf(this.getBorn()).compareTo(that.getBorn());
    }

}
