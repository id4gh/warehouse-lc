package com.lc.warehouse.verificationcode.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author mayanchao
 */
public class Mappers {
    private static final String IMPLEMENTATION_SUFFIX = "Impl";

    private Mappers() {
    }

    public static <T> T getMapper(Class<T> clazz) {
        try {
            List<ClassLoader> classLoaders = collectClassLoaders(clazz.getClassLoader());
            return getMapper(clazz, classLoaders);
        } catch (NoSuchMethodException | ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }

    }

    private static <T> T getMapper(Class<T> mapperType, Iterable<ClassLoader> classLoaders) throws ClassNotFoundException, NoSuchMethodException {
        Iterator var2 = classLoaders.iterator();

        Object mapper;
        do {
            if (!var2.hasNext()) {
                throw new ClassNotFoundException("Cannot find implementation for " + mapperType.getName());
            }

            ClassLoader classLoader = (ClassLoader)var2.next();
            mapper = doGetMapper(mapperType, classLoader);
        } while(mapper == null);

        return (T) mapper;
    }

    private static <T> T doGetMapper(Class<T> clazz, ClassLoader classLoader) throws NoSuchMethodException {
        try {
            Class<T> implementation = (Class<T>) classLoader.loadClass(clazz.getName() + "Impl");
            Constructor<T> constructor = implementation.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (ClassNotFoundException var4) {
            return getMapperFromServiceLoader(clazz, classLoader);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException var5) {
            throw new RuntimeException(var5);
        }
    }

    public static <T> Class<? extends T> getMapperClass(Class<T> clazz) {
        try {
            List<ClassLoader> classLoaders = collectClassLoaders(clazz.getClassLoader());
            return getMapperClass(clazz, classLoaders);
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }
    }

    private static <T> Class<? extends T> getMapperClass(Class<T> mapperType, Iterable<ClassLoader> classLoaders) throws ClassNotFoundException {
        Iterator var2 = classLoaders.iterator();

        Class mapperClass;
        do {
            if (!var2.hasNext()) {
                throw new ClassNotFoundException("Cannot find implementation for " + mapperType.getName());
            }

            ClassLoader classLoader = (ClassLoader)var2.next();
            mapperClass = doGetMapperClass(mapperType, classLoader);
        } while(mapperClass == null);

        return mapperClass;
    }

    private static <T> Class<? extends T> doGetMapperClass(Class<T> clazz, ClassLoader classLoader) {
        try {
            return (Class<? extends T>) classLoader.loadClass(clazz.getName() + "Impl");
        } catch (ClassNotFoundException var4) {
            T mapper = getMapperFromServiceLoader(clazz, classLoader);
            return mapper != null ? (Class<? extends T>) mapper.getClass() : null;
        }
    }

    private static <T> T getMapperFromServiceLoader(Class<T> clazz, ClassLoader classLoader) {
        ServiceLoader<T> loader = ServiceLoader.load(clazz, classLoader);
        Iterator var3 = loader.iterator();

        Object mapper;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            mapper = var3.next();
        } while(mapper == null);

        return (T) mapper;
    }

    private static List<ClassLoader> collectClassLoaders(ClassLoader classLoader) {
        List<ClassLoader> classLoaders = new ArrayList(3);
        classLoaders.add(classLoader);
        if (Thread.currentThread().getContextClassLoader() != null) {
            classLoaders.add(Thread.currentThread().getContextClassLoader());
        }

        classLoaders.add(Mappers.class.getClassLoader());
        return classLoaders;
    }
}
