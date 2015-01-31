package com.blogspot.minborgsjavapot.singleton;

/**
 *
 * @author pemi
 */
public class FooSingleton2 {

    private static boolean INSTANCE_CREATED;
    public final static FooSingleton2 INSTANCE = new FooSingleton2();

    private FooSingleton2() {
        if (INSTANCE_CREATED) {
            throw new IllegalStateException("You must only create one instance of this class");
        } else {
            INSTANCE_CREATED = true;
        }
    }

    public void bar() {
    }

}
