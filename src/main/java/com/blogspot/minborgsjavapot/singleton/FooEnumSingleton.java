package com.blogspot.minborgsjavapot.singleton;

/**
 *
 * @author pemi
 */
public enum FooEnumSingleton {

    INSTANCE;

    public static FooEnumSingleton getInstance() { return INSTANCE; }

    public void bar() { }

}
