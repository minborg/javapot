package com.blogspot.minborgsjavapot.multiple_inherit.generic;

/**
 *
 * @author pemi
 */
public class Person extends DefaultStateful implements Named, Addressed {

    // Expose this just for testing
    public static int size() {
        return Hidden.size();
    }

}
