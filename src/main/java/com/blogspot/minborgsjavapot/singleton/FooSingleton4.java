package com.blogspot.minborgsjavapot.singleton;

/**
 *
 * @author pemi
 */
public class FooSingleton4 {
    
    private FooSingleton4() {
    }
    
    public static FooSingleton4 getInstance() {
        return FooSingleton4Holder.INSTANCE;
    }
    
    private static class FooSingleton4Holder {

        private static final FooSingleton4 INSTANCE = new FooSingleton4();
    }
}
