package com.blogspot.minborgsjavapot.objectmixin._6interface_annotation;

import com.blogspot.minborgsjavapot.objectmixin._7interface_reflection.performance.ReflectionObjectMixin;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author pemi
 * @param <T>
 */
public interface AnnotationObjectMixin<T extends AnnotationObjectMixin<T>> extends ObjectMixin<T> {

    @Override
    default Object[] members() {
        return new MethodUtil(getClass(), EqualsAndHashCode.class) {

            @Override
            protected Object onMethod(final Method method) {
                try {
                    return method.invoke(AnnotationObjectMixin.this, (Object[]) null);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new IllegalStateException("Unexpected invocation error", e);
                }
            }
        }.toObjects();

    }

    @Override
    default Object[] names() {

        return new MethodUtil(getClass(), EqualsAndHashCode.class) {

            @Override
            protected Object onMethod(final Method method) {
                final String methodName = method.getName();
                if (methodName.startsWith(INGRESS)) {
                    return methodName.substring(ReflectionObjectMixin.MethodUtil.INGRESS.length());
                } else {
                    return methodName;
                }
            }
        }.toObjects();

    }

    static abstract class MethodUtil {

        public static final String INGRESS = "get";
        private final Class<?> clazz;
        private final Class<? extends Annotation> annotationClass;

        private MethodUtil(Class<?> clazz, Class<? extends Annotation> annotationClass) {
            this.clazz = clazz;
            this.annotationClass = annotationClass;
        }

        private static List<Method> obtainGetMethods(Class<?> clazz, Class<? extends Annotation> annotationClass) {
            final List<Method> result = new ArrayList<>();
            final Method[] methods = clazz.getMethods();
            for (final Method method : methods) {
                if (method.getParameterCount() == 0 && (method.getAnnotation(annotationClass) != null)) {
                    result.add(method);
                }
            }
            Collections.sort(result, METHOD_COMPARATOR);
            return result;
        }

        protected abstract Object onMethod(Method method);

        public Object[] toObjects() {
            final List<Object> result = new ArrayList<>();
            for (final Method method : MethodUtil.obtainGetMethods(clazz, annotationClass)) {
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
