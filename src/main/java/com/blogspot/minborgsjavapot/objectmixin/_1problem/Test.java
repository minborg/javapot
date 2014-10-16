package com.blogspot.minborgsjavapot.objectmixin._1problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pemi
 */
public class Test {

    public static void main(String[] args) {
        final Person adam = new Person("Adam", "adam@mail.com", 1966);
        final Person adam2 = new Person("Adam", "adam@mail.com", 1966);
        final Person adamYoung = new Person("Adam", "adam_88@mail.com", 1988);
        final Person bert = new Person("Bert", "bert@mail.com", 1979);
        final Person bert2 = new Person("Bert", "bert@mail.com", 1979) {

            @Override
            public String toString() {
                return "Strange:" + super.toString();
            }

        };
        final Person cecelia = new FemalePerson("Guchi", "Cecelia", "cecelia@mail.com", 1981);
        final Person ceceliaPro = new FemalePerson("Guchi Pro", "Cecelia", "cecelia@mail.com", 1981);
        final Person cecelia2 = new Person("Cecelia", "cecelia@mail.com", 1981);

        printEquals(adam, adam2);
        printEquals(adam2, adam);
        printEquals(bert, bert2);
        printEquals(bert2, bert);
        printEquals(cecelia, cecelia2);
        printEquals(cecelia2, cecelia);

        final List<Person> l = Arrays.asList(cecelia, adamYoung, ceceliaPro, cecelia2, adam, bert, adam2, bert2);

        System.out.println("*** Initial order");
        l.forEach(System.out::println);
        System.out.println("*** Sorted order");
        Collections.sort(l);
        l.forEach(System.out::println);

    }

    private static void printEquals(Person p1, Person p2) {
        System.out.println("It is " + p1.equals(p2) + " that " + p1 + " equals " + p2
                + ". hashCode()s are " + ((p1.hashCode() == p2.hashCode()) ? "equals" : "are different"));
    }

}
