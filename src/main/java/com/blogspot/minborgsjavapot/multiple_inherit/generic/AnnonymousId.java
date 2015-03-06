package com.blogspot.minborgsjavapot.multiple_inherit.generic;

import java.util.Optional;

/**
 *
 * @author pemi
 */
public interface AnnonymousId extends Stateful {

    default Optional<String> getFirstName() {
        return Hidden.get(this, "firstName");
    }

    default Optional<String> getCity() {
        return Hidden.get(this, "city");
    }

    default String annonymousId() {
        return getFirstName() + " in " + getCity();
    }

}
