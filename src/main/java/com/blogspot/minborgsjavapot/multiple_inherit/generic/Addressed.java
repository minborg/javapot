package com.blogspot.minborgsjavapot.multiple_inherit.generic;

import java.util.Optional;

/**
 *
 * @author pemi
 */
public interface Addressed extends Stateful {

    default void setAddress(String address) {
        Hidden.set(this, "address", address);
    }

    default Optional<String> getAddress() {
        return Hidden.get(this, "address");
    }

    default void setCity(String city) {
        Hidden.set(this, "city", city);
    }

    default Optional<String> getCity() {
        return Hidden.get(this, "city");
    }

}
