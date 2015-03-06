package com.blogspot.minborgsjavapot.multiple_inherit.generic;

import java.util.Optional;

/**
 *
 * @author pemi
 */
public class PersonWithAnnonymousId extends DefaultStateful implements Named, Addressed, AnnonymousId {

    @Override
    public Optional<String> getFirstName() {
        return Named.super.getFirstName();
    }

    @Override
    public Optional<String> getCity() {
        return Addressed.super.getCity();
    }

    public static int size() {
        return Hidden.size();
    }

}
