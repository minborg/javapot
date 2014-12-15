/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.minborgsjavapot.fastmap;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author pemi
 */
public class IntArrayMapTest {

    private static final int MIN_TEST_VAL = 0;
    private static final int MAX_TEST_VAL = 20;
    private static final int MID_TEST_VAL = (MIN_TEST_VAL + MAX_TEST_VAL) / 2;

    IntArrayMap<String> instance;
    Map<Integer, String> expResult;

    public IntArrayMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new IntArrayMap<>(MIN_TEST_VAL, MAX_TEST_VAL);
        expResult = new HashMap<>();
    }

    @After
    public void tearDown() {
    }

    public void fillWithTestData() {
        fillWithTestData(instance);
        fillWithTestData(expResult);
    }

    public void fillWithTestData(Map<Integer, String> map) {
        for (int i = MIN_TEST_VAL; i < MAX_TEST_VAL; i++) {
            map.put(i, Integer.toString(i));
        }
    }

    /**
     * Test of makeKeyFromInt method, of class IntMap.
     */
    @Test
    public void testIntMap() {
        final IntArrayMap<String> map = new IntArrayMap<>(1, 30);
        assertEquals(Collections.emptyMap(), map);
    }

    @Test
    public void testPutAll() {
        final Map<Integer, String> original = new TreeMap<>();
        original.put(1, "a");
        original.put(2, "b");
        original.put(3, "c");
        final IntArrayMap<String> map = new IntArrayMap<>(1, 3);
        map.putAll(original);
        assertEquals(original, map);
    }

    @Test
    public void testEntrySetIterator() {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "World");
        map.put(2, "second");
        map.put(3, "lubricants");
        map.put(4, "betical");

        IntArrayMap<String> copy = new IntArrayMap<>(1, 4);
        copy.putAll(map);

        Iterator<Entry<Integer, String>> iter = copy.entrySet().iterator();
        assertTrue(iter.hasNext());
        Entry<Integer, String> entry = iter.next();
        assertEquals(1, (int) entry.getKey());
        assertEquals("World", entry.getValue());
        assertTrue(iter.hasNext());

        entry = iter.next();
        assertEquals(2, (int) entry.getKey());
        assertEquals("second", entry.getValue());
        assertTrue(iter.hasNext());

        entry = iter.next();
        assertEquals(3, (int) entry.getKey());
        assertEquals("lubricants", entry.getValue());
        assertTrue(iter.hasNext());

        entry = iter.next();
        assertEquals(4, (int) entry.getKey());
        assertEquals("betical", entry.getValue());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testEntrySet() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "World");
        map.put(2, "second");
        map.put(3, "lubricants");
        map.put(4, "betical");

        IntArrayMap<String> copy = new IntArrayMap<>(1, 4);
        copy.putAll(map);

        Set<Entry<Integer, String>> set = copy.entrySet();

        assertEquals(4, set.size());
        assertTrue(set.contains(new AbstractMap.SimpleEntry<>(1, "World")));

        assertTrue(set.remove(new AbstractMap.SimpleEntry<>(1, "World")));
        assertFalse(set.contains(new AbstractMap.SimpleEntry<>(1, "World")));

        AtomicInteger val = new AtomicInteger();
        set.forEach((t) -> {
            val.incrementAndGet();
        });
        assertEquals(3, val.get());
        assertEquals(3, set.size());

        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Ignore
    @Test
    // Spliterators are not optimized yet. TODO
    public void testEntrySetSpliterator() {
        final Set<Entry<Integer, String>> set = instance.entrySet();
        Spliterator<Entry<Integer, String>> spliterator = set.spliterator();

        assertTrue(spliterator.hasCharacteristics(Spliterator.DISTINCT));
        assertTrue(spliterator.hasCharacteristics(Spliterator.ORDERED));

        Spliterator<Entry<Integer, String>> spliteratorChild = spliterator.trySplit();

        assertNotNull(spliteratorChild);

        final AtomicInteger val = new AtomicInteger();
        spliterator.forEachRemaining((t) -> {
            val.incrementAndGet();
        });
        spliteratorChild.forEachRemaining((t) -> {
            val.incrementAndGet();
        });
        assertEquals(instance.size(), val.get());

    }

    @Test
    public void testInsertNull() {
        try {
            instance.put(1, null);
            fail("Illegal to insert null");
        } catch (NullPointerException npe) {
            // Ignore
        }
    }

    @Test
    public void testMakeKeyFromInt() {
        System.out.println("makeKeyFromInt");
        assertEquals(Integer.valueOf(1), instance.makeKeyFromInt(1));
    }

    @Test
    public void testPutInteger() {
        System.out.println("testPutInteger");
        fillWithTestData();
        assertEquals(expResult, instance);
    }

    @Test
    public void testRemove() {
        System.out.println("testRemove");
        fillWithTestData();
        assertEquals(Integer.toString(MID_TEST_VAL), expResult.remove(MID_TEST_VAL));
        instance.remove(MID_TEST_VAL);
        assertEquals(expResult, instance);
    }

    @Test
    public void testSize() {
        System.out.println("testSize");
        fillWithTestData();
        assertEquals(expResult.size(), instance.size());
        expResult.remove(MID_TEST_VAL);
        instance.remove(MID_TEST_VAL);
        assertEquals(expResult.size(), instance.size());

    }

    @Test
    public void testSerialize() {
        System.out.println("testSerialize");
        fillWithTestData();

        try (final ByteArrayOutputStream bos = new ByteArrayOutputStream(10000); final ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(instance);
            oos.flush();

            byte[] b = bos.toByteArray();

            final ByteArrayInputStream bis = new ByteArrayInputStream(b);
            final ObjectInputStream ois = new ObjectInputStream(bis);
            try {

                @SuppressWarnings("unchecked")
                final IntArrayMap<String> result = (IntArrayMap<String>) ois.readObject();

                assertEquals(instance, result);
            } catch (Exception e) {
                fail(e.getMessage());
            }
        } catch (IOException ioe) {
            fail(ioe.getMessage());
        }
    }

    // Test Java 8 and spliterators
    // https://google-collections.googlecode.com/svn/trunk/test/com/google/common/collect/MapsTest.java
}
