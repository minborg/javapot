package com.blogspot.minborgsjavapot.immutables._1simple;

public class Main {

    public static void main(String[] args) {
        final Author author = new Author("William Shakespeare", 1564);

        System.out.println(author.getName() + " was born in " + author.getBornYear());

    }

}
