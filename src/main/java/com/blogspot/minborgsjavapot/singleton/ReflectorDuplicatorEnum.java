package com.blogspot.minborgsjavapot.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author pemi
 */
public class ReflectorDuplicatorEnum {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {

        Constructor con = FooEnumSingleton.class.getDeclaredConstructors()[0];
        Method[] methods = con.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("acquireConstructorAccessor")) {
                method.setAccessible(true);
                method.invoke(con, new Object[0]);
            }
        }
        Field[] fields = con.getClass().getDeclaredFields();
        Object ca = null;
        for (Field field : fields) {
            if (field.getName().equals("constructorAccessor")) {
                field.setAccessible(true);
                ca = field.get(con);
            }
        }
        Method method = ca.getClass().getMethod("newInstance", new Class[]{Object[].class});
        method.setAccessible(true);
        FooEnumSingleton spuriousEnum = (FooEnumSingleton) method.invoke(ca, new Object[]{new Object[]{"SPURIOUS_INSTANCE", 1}});
        printInfo(FooEnumSingleton.INSTANCE);
        printInfo(spuriousEnum);
    }

    private static void printInfo(FooEnumSingleton e) {
        System.out.println(e.getClass() + ":" + e.name() + ":" + e.ordinal());
    }

}
