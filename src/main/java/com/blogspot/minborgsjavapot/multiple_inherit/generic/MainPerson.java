package com.blogspot.minborgsjavapot.multiple_inherit.generic;

import java.util.stream.IntStream;

/**
 *
 * @author pemi
 */
public class MainPerson {

    private static final int SIZE = 10_000;

    public static void main(String[] args) {
        
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setAddress("1 University Avenue");
        person.setCity("Palo Alto");

        System.out.println(person);
        
        
        Person p1 = new Person();
        Person p2 = new Person();

        System.out.println(p1.toString().equals(p2.toString()));

        p1.setCity("Palo Alto");
        System.out.println("p1: " + p1);
        System.out.println(p1.equals(p2));

       
        System.out.println(p1.getCity());

        p2.setCity("Palo Alto");
        System.out.println(p1.toString().equals(p2.toString()));

        final Person[] persons = new Person[SIZE];
        IntStream.range(0, SIZE).forEach(i -> {
            persons[i] = new Person() {
            };
            persons[i].setFirstName("" + i);
        });

        System.out.println(Person.size());

        IntStream.range(0, SIZE).forEach(i -> {
            persons[i] = null;
        });

        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {

        }
        System.out.println(Person.size());

    }

}
