package com.blogspot.minborgsjavapot.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author pemi
 */
public class ReflectorDuplicator2 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

        Field f = FooSingleton2.class.getDeclaredField("INSTANCE_CREATED");
        f.setAccessible(true);
        f.set(null, false);

        Constructor[] constructors = FooSingleton2.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        FooSingleton2 spuriousFoo = (FooSingleton2) constructor.newInstance(new Object[0]);

    }

}
