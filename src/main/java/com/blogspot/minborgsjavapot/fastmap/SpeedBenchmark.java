package com.blogspot.minborgsjavapot.fastmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author pemi
 *
 * HashMap: 5000000000 iterations in 40737 ms (122 MTPS)
 *
 * ConcurrentHashMap: 5000000000 iterations in 42616 ms (117 MTPS)
 *
 * IntArrayMap: 5000000000 iterations in 29138 ms (171 MTPS)
 *
 * IntArrayMap: 5000000000 iterations in 9584 ms (521 MTPS)
 */
public class SpeedBenchmark {

    private static final long WARMUP_RATIO = 2;
    private static final long LOOPS = WARMUP_RATIO * (100000 / WARMUP_RATIO); // Must be evenly dividable with WARMUP_RATIO
    private static final long START_LOOP_COUNT = LOOPS / WARMUP_RATIO;

    private static final int MAP_SIZE = 100000;

    private static final long ITERATIONS = (LOOPS - START_LOOP_COUNT) * MAP_SIZE;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(ITERATIONS + " iterations.");
        new Bench<>(initMap(new HashMap<>())).run();
        new Bench<>(initMap(new TreeMap<>())).run();
        new Bench<>(initMap(new LinkedHashMap<>())).run();
        new Bench<>(initMap(new ConcurrentHashMap<>())).run();

        new Bench<>(initMap(new IntArrayMap<>(0, MAP_SIZE))).run();

        final IntArrayMap<String> intArrayMap = initMap(new IntArrayMap<>(0, MAP_SIZE));
        new Bench<IntArrayMap<String>>(intArrayMap) {

            @Override
            protected void getFromMap(int i) {
                intArrayMap.get(i);
            }

        }.run();

    }

    private static <M extends Map<Integer, String>> M initMap(M map) {
        for (int i = 0; i < MAP_SIZE; i++) {
            map.put(i, Integer.toHexString(i));
        }
        return map;
    }

    private static class Bench<M extends Map<Integer, String>> implements Runnable {

        private final M map;

        public Bench(M map) {
            this.map = map;
        }

        @Override
        public void run() {
            long start = 0;
            for (int n = 0; n < LOOPS; n++) {
                if (n == START_LOOP_COUNT) {
                    // Wait until JIT/cache is warm
                    start = System.currentTimeMillis();
                }
                for (int i = 0; i < MAP_SIZE; i++) {
                    getFromMap(i);
                }
            }
            long duration = System.currentTimeMillis() - start;

            long mtps = ITERATIONS / duration / 1000;
            System.out.format("%18s %8s ms, %5s MTSP\n", map.getClass().getSimpleName(), duration, mtps);
            //System.out.println(map.getClass().getSimpleName() + ": " + iterations + " iterations in " + duration + " ms (" + mtps + " MTPS)");
        }

        protected void getFromMap(int i) {
            map.get(i);
        }

    }

}
