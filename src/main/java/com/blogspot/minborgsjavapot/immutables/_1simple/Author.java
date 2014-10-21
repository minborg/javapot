package com.blogspot.minborgsjavapot.immutables._1simple;

public class Author {

    private final String name;
    private final int bornYear;

    public Author(final String name, final int bornYear) {
        this.name = name;
        this.bornYear = bornYear;
    }

    public String getName() {
        return name;
    }

    public int getBornYear() {
        return bornYear;
    }

}
