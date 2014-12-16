package com.blogspot.minborgsjavapot.fastmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 *
 * @author pemi
 */
public class HeapBenchmark {

    private static final int MAP_SIZE = 10000000;

    public static void main(String[] args) {
        new Bench(() -> new HashMap(MAP_SIZE)).run();
        new Bench(TreeMap::new).run();
        new Bench(() -> new LinkedHashMap(MAP_SIZE)).run();
        new Bench(() -> new ConcurrentHashMap(MAP_SIZE)).run();
        new Bench(() -> new IntArrayMap<>(0, MAP_SIZE)).run();
    }

    private static <M extends Map<Integer, String>> M initMap(M map) {
        for (int i = 0; i < MAP_SIZE; i++) {
            map.put(i, "SAME_TEST_STRING_ALL_OVER_THE_MAP");
        }
        return map;
    }

    private static class Bench implements Runnable {

        final private Supplier<Map<Integer, String>> mapSupplier;

        public Bench(Supplier<Map<Integer, String>> mapSupplier) {
            this.mapSupplier = mapSupplier;
        }

        @Override
        public void run() {
            System.gc();
            System.gc();
            long begin = usedMemory();
            final Map<Integer, String> map = mapSupplier.get();
            initMap(map);
            System.gc();
            System.gc();
            long end = usedMemory();
            long allocation = end - begin;
            long allocationPerEntry = allocation / MAP_SIZE;
            System.out.format("%18s %6d MB %6d bytes per entry (excluding size of value object)\n", map.getClass().getSimpleName(), allocation / 100000, allocationPerEntry);
        }

    }

    private static long usedMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

}
