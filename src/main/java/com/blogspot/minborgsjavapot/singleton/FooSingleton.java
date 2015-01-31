package com.blogspot.minborgsjavapot.singleton;

/**
 *
 * @author pemi
 */
public class FooSingleton {

    public final static FooSingleton INSTANCE = new FooSingleton();

    private FooSingleton() { }
    
    public void bar() { }
        
}
