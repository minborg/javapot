package com.blogspot.minborgsjavapot.multiple_inherit.generic;

import java.util.Optional;

/**
 *
 * @author pemi
 */
public interface Named extends Stateful {

    default void setFirstName(String firstName) {
        Hidden.set(this, "firstName", firstName);
    }

    default Optional<String> getFirstName() {
        return Hidden.get(this, "firstName");
    }

    default void setLastName(String lastName) {
        Hidden.set(this, "lastName", lastName);
    }

    default Optional<String> getLastName() {
        return Hidden.get(this, "lastName");
    }

}
