package com.blogspot.minborgsjavapot.objectmixin._7interface_reflection.performance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author pemi
 * @param <T>
 */
public interface ReflectionObjectMixin<T extends ReflectionObjectMixin<T>> extends ObjectMixin<T> {

    @Override
    default Object[] members() {
        return new MethodUtil(getClass()) {

            @Override
            protected Object onMethod(final Method method) {
                try {
                    return method.invoke(ReflectionObjectMixin.this, (Object[]) null);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalStateException("Unexpected invocation error", e);
                }
            }
        }.toObjects();

    }

    @Override
    default Object[] names() {

        return new MethodUtil(getClass()) {

            @Override
            protected Object onMethod(final Method method) {
                return method.getName().substring(MethodUtil.INGRESS.length());
            }
        }.toObjects();

    }

    static abstract class MethodUtil {

        public static final String INGRESS = "get";
        public static final Set<String> EXCLUDED_METHODS = new HashSet<>(Arrays.asList("getClass"));
        private final Class<?> clazz;

        private MethodUtil(Class<?> clazz) {
            this.clazz = clazz;
        }

        private static final Map<Class<?>, List<Method>> methodCache = new ConcurrentHashMap<>();

        private static List<Method> obtainGetMethods(Class<?> clazz) {

            List<Method> cacheResult = methodCache.get(clazz);
            if (cacheResult != null) {
                return cacheResult;
            } else {
                final List<Method> result = new ArrayList<>();
                final Method[] methods = clazz.getMethods();
                for (final Method method : methods) {
                    final String methodName = method.getName();
                    if (methodName.startsWith(INGRESS) && method.getParameterCount() == 0 && !EXCLUDED_METHODS.contains(methodName)) {
                        result.add(method);
                    }
                }
                Collections.sort(result, METHOD_COMPARATOR);
                methodCache.put(clazz, result);
                return result;
            }
        }

        protected abstract Object onMethod(Method method);

        public Object[] toObjects() {
            final List<Object> result = new ArrayList<>();
            for (final Method method : MethodUtil.obtainGetMethods(clazz)) {
                result.add(onMethod(method));
            }
            return result.toArray();
        }

        private final static MethodComparator METHOD_COMPARATOR = new MethodComparator();

        private static class MethodComparator implements Comparator<Method> {

            @Override
            public int compare(Method o1, Method o2) {
                int classCompare = o1.getDeclaringClass().getName().compareTo(o2.getDeclaringClass().getName());
                if (classCompare != 0) {
                    return classCompare;
                }
                return o1.getName().compareTo(o2.getName());
            }

        }

    }

}
