/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.minborgsjavapot.concurrent_set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pemi
 */
public class ConcurrentHashSetTest {

    private static final Set<String> TEST_SET = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("A", "B", "C")));

    public ConcurrentHashSetTest() {
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
     * Test of clear method, of class ConcurrentHashSet.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.add("A");
        assertFalse(instance.isEmpty());
        instance.clear();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of size method, of class ConcurrentHashSet.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        assertEquals(0, instance.size());
        instance.add("A");
        assertEquals(1, instance.size());
        instance.remove("A");
        assertEquals(0, instance.size());
    }

    /**
     * Test of isEmpty method, of class ConcurrentHashSet.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        assertTrue(instance.isEmpty());
        instance.add("A");
        assertFalse(instance.isEmpty());
        instance.remove("A");
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of contains method, of class ConcurrentHashSet.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.add("A");
        assertTrue(instance.contains("A"));
    }

    /**
     * Test of remove method, of class ConcurrentHashSet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object o = null;
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.add("A");
        assertFalse(instance.remove("B"));
        assertTrue(instance.remove("A"));
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of add method, of class ConcurrentHashSet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        assertTrue(instance.add("A"));
        assertFalse(instance.add("A"));
    }

    /**
     * Test of iterator method, of class ConcurrentHashSet.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(TEST_SET);
        Iterator<String> iterator = instance.iterator();
        Set<String> collectedItems = new HashSet<>();
        while (iterator.hasNext()) {
            collectedItems.add(iterator.next());
        }
        assertEquals(TEST_SET, collectedItems);
    }

    /**
     * Test of toArray method, of class ConcurrentHashSet.
     */
    @Test
    @SuppressWarnings("rawtypes")
    public void testToArray_0args() {
        System.out.println("toArray");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(TEST_SET);
        Object[] resultArray = instance.toArray();
        // The oder is undefined... So we can use Set to test equality
        @SuppressWarnings("unchecked")
        Set<String> result = new HashSet(Arrays.asList(resultArray));
        assertEquals(TEST_SET, result);
    }

    /**
     * Test of toArray method, of class ConcurrentHashSet.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        String[] a = new String[1];
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(TEST_SET);
        String[] resultArray = instance.toArray(a);
        // The oder is undefined... So we can use Set to test equality
        Set<String> result = new HashSet<>(Arrays.asList(resultArray));
        assertEquals(TEST_SET, result);
    }

    /**
     * Test of toString method, of class ConcurrentHashSet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(TEST_SET);
        String result = instance.toString();
        for (String s : TEST_SET) {
            assertTrue(result.contains(s));
        }
    }

    /**
     * Test of hashCode method, of class ConcurrentHashSet.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(TEST_SET);
        assertEquals(TEST_SET.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method, of class ConcurrentHashSet.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(TEST_SET);
        assertEquals(TEST_SET, instance);
        instance.add("qwerty");
        assertNotSame(TEST_SET, instance);
    }

    /**
     * Test of containsAll method, of class ConcurrentHashSet.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>(TEST_SET);
        assertTrue(instance.containsAll(TEST_SET));
        instance.add("qwerty");
        assertTrue(instance.containsAll(TEST_SET));
    }

    /**
     * Test of removeAll method, of class ConcurrentHashSet.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(Arrays.asList("A", "B", "C", "D", "E"));
        assertTrue(instance.removeAll(Arrays.asList("A", "C", "E")));
        assertEquals(new HashSet<>(Arrays.asList("B", "D")), instance);
        assertFalse(instance.removeAll(Arrays.asList("A", "C", "E")));
    }

    /**
     * Test of retainAll method, of class ConcurrentHashSet.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        instance.addAll(Arrays.asList("A", "B", "C", "D", "E"));
        assertTrue(instance.retainAll(Arrays.asList("B", "D")));
        assertEquals(new HashSet<>(Arrays.asList("B", "D")), instance);
        assertFalse(instance.retainAll(Arrays.asList("B", "D")));
    }

    /**
     * Test of addAll method, of class ConcurrentHashSet.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
        assertTrue(instance.addAll(TEST_SET));
        assertEquals(TEST_SET, instance);
        assertFalse(instance.addAll(TEST_SET));
    }

//    /**
//     * Test of addIfAbsent method, of class ConcurrentHashSet.
//     */
//    @Test
//    public void testAddIfAbsent() {
//        System.out.println("addIfAbsent");
//        // Hard to test atomic operation...
//        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>();
//        assertTrue(instance.addIfAbsent("A"));
//        assertFalse(instance.addIfAbsent("A"));
//    }

    /**
     * Test of forEach method, of class ConcurrentHashSet.
     */
    @Test
    public void testForEach() {
        System.out.println("forEach");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>(TEST_SET);
        final Set<String> result = new HashSet<>();
        instance.forEach((e) -> result.add(e));
        assertEquals(TEST_SET, result);
    }

    /**
     * Test of removeIf method, of class ConcurrentHashSet.
     */
    @Test
    public void testRemoveIf() {
        System.out.println("removeIf");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>(TEST_SET);
        instance.add("qwerty");
        instance.removeIf((e) -> !TEST_SET.contains(e));
        assertEquals(TEST_SET, instance);
    }

    /**
     * Test of spliterator method, of class ConcurrentHashSet.
     */
    @Test
    public void testSpliterator() {
        System.out.println("spliterator");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>(TEST_SET);
        Spliterator<String> result = instance.spliterator();
        Set<String> resultSet = new HashSet<>();
        result.forEachRemaining((o) -> resultSet.add(o));
        assertEquals(TEST_SET, resultSet);
    }

    /**
     * Test of stream method, of class ConcurrentHashSet.
     */
    @Test
    public void testStream() {
        System.out.println("stream");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>(TEST_SET);
        Stream<String> result = instance.stream();
        Set<String> resultSet = new HashSet<>();
        result.forEach((o) -> resultSet.add(o));
        assertEquals(TEST_SET, resultSet);
    }

    /**
     * Test of parallelStream method, of class ConcurrentHashSet.
     */
    @Test
    public void testParallelStream() {
        System.out.println("parallelStream");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<>(TEST_SET);
        Stream<String> result = instance.parallelStream();
        Set<String> resultSet = new HashSet<>();
        result.forEach((o) -> resultSet.add(o));
        assertEquals(TEST_SET, resultSet);
    }

    @Test
    public void testConstructorProvider() {
        System.out.println("testConstructorProvider");
        ConcurrentHashSet<String> instance = new ConcurrentHashSet<String>(ConcurrentSkipListMap::new);
        instance.add("C");
        instance.add("A");
        instance.add("B");
        assertEquals(Arrays.asList("A", "B", "C"), Arrays.asList(instance.toArray()));
    }

}
