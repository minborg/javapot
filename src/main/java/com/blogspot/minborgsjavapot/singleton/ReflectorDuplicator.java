package com.blogspot.minborgsjavapot.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author pemi
 */
public class ReflectorDuplicator {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor[] constructors = FooSingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        FooSingleton spuriousFoo = (FooSingleton) constructor.newInstance(new Object[0]);
    }

}
