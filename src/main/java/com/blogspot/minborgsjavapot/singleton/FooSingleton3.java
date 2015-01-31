package com.blogspot.minborgsjavapot.singleton;

/**
 *
 * @author pemi
 */
public class FooSingleton3 {

    public final static FooSingleton3 INSTANCE = new FooSingleton3();

    private FooSingleton3() { }

    public static FooSingleton3 getInstance() { return INSTANCE; }

    public void bar() { }

}
