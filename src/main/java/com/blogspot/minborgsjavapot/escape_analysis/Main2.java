package com.blogspot.minborgsjavapot.escape_analysis;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Person p = new Person("Johan", "Sebastian", "Bach");

        count(p);
        System.gc();
        System.out.println("Press any key to continue");
        System.in.read();
        //Thread.sleep(1_000);
        long sum = count(p);

        System.out.println(sum);
        System.out.println("Press any key to continue2");
        System.in.read();

        sum = count(p);

        System.out.println(sum);
        System.out.println("Press any key to exit");
        System.in.read();

    }

    private static long count(Person p) {
        long count = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (p.getMiddleName().isPresent()) {
                count++;
            }
        }
        return count;

    }

}
