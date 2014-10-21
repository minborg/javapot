package com.blogspot.minborgsjavapot.immutables._5unmod3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author {

    private final String name;
    private final int bornYear;
    private final List<String> works;

    public Author(final String name, final int bornYear, final List<String> works) {
        this.name = name;
        this.bornYear = bornYear;
        // Now we make a new List that is a copy of the provided works list
        this.works = Collections.unmodifiableList(new ArrayList<>(works));
    }

    public String getName() {
        return name;
    }

    public int getBornYear() {
        return bornYear;
    }

    public List<String> getWorks() {
        return works;
    }

}
