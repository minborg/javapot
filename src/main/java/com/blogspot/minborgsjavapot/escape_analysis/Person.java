package com.blogspot.minborgsjavapot.escape_analysis;

import static java.util.Objects.requireNonNull;
import java.util.Optional;

/**
 *
 * @author pemi
 */
public class Person {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = requireNonNull(firstName); // Cannot be null
        this.middleName = middleName;   // Can be null
        this.lastName = requireNonNull(lastName); // Cannot be null
    }

    public String getFirstName() {
        return firstName;
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public String getLastName() {
        return lastName;
    }

}
