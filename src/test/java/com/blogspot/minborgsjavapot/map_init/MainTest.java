/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.minborgsjavapot.map_init;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pemi
 */
public class MainTest {

    private static final Map<Integer, String> REFERENCE_MAP = new HashMap<>();

    static {
        REFERENCE_MAP.put(0, "zero");
        REFERENCE_MAP.put(1, "one");
        REFERENCE_MAP.put(2, "two");
        REFERENCE_MAP.put(3, "three");
        REFERENCE_MAP.put(4, "four");
        REFERENCE_MAP.put(5, "five");
        REFERENCE_MAP.put(6, "six");
        REFERENCE_MAP.put(7, "seven");
        REFERENCE_MAP.put(8, "eight");
        REFERENCE_MAP.put(9, "nine");
        REFERENCE_MAP.put(10, "ten");
        REFERENCE_MAP.put(11, "eleven");
        REFERENCE_MAP.put(12, "twelve");

    }

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void test() {
        test(Main::imperative);
        test(Main::doubleBracket);
        test(Main::builderPattern);
        test(Main::concurrentBuilder);
        test(Main::stdJava8);
        test(Main::extJava8);
    }

    private void test(Supplier<Map<Integer, String>> mapSupplier) {
        final Map<Integer, String> testMap = mapSupplier.get();
        assertEquals(REFERENCE_MAP, testMap);
        if (!(testMap instanceof ConcurrentMap)) {
            try {
                testMap.put(1, "Olle");
                Assert.fail("Map was not unmodifiable");
            } catch (Exception e) {
                // Ignore
            }
        }
    }
}
