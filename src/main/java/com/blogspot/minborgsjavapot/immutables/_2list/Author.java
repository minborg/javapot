package com.blogspot.minborgsjavapot.immutables._2list;

import java.util.List;

public class Author {

    private final String name;
    private final int bornYear;
    private final List<String> works;

    public Author(final String name, final int bornYear, final List<String> works) {
        this.name = name;
        this.bornYear = bornYear;
        this.works = works;
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
