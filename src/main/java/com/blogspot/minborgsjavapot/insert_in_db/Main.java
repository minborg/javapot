package com.blogspot.minborgsjavapot.insert_in_db;

import com.speedment.Manager;
import com.speedment.Speedment;
import com.speedment.exception.SpeedmentException;

public class Main {

    public static void main(String[] args) {
        // Setup
        /*

        Speedment speedment = new JavapotApplication().withPassword("javapot").build();
        Manager<Country> countries = speedment.managerOf(Country.class);

        try {
            countries.newInstance()
                    .setName("United States")
                    .setLocalName("United States")
                    .setCode(1)
                    .setDomain(".us")
                    .persist();

            countries.newInstance()
                    .setName("Germany")
                    .setLocalName("Deutschland")
                    .setCode(49)
                    .setDomain(".de")
                    .persist();

            // Needless to say, you can call the 
            // setters in any order.
            countries.newInstance()
                    .setDomain(".uk")
                    .setCode(44)
                    .setName("United Kingdom")
                    .setLocalName("United Kingdom")
                    .setDomain(".uk")
                    .persist();

            countries.newInstance()
                    .setName("Sweden")
                    .setLocalName("Sverige")
                    .setCode(40) // Intentionally wrong
                    .setDomain(".se")
                    .persist();

            countries.stream()
                    .filter(Country.NAME.equal("Sweden"))
                    .findAny()
                    .ifPresent(c -> c.setCode(46).update());

        } catch (SpeedmentException se) {

        }
        */
    }

}
