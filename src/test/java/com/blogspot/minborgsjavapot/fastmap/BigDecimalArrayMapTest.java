/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.minborgsjavapot.fastmap;

import java.math.BigDecimal;
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
public class BigDecimalArrayMapTest {

    BigDecimalArrayMap<String> instance;

    public BigDecimalArrayMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new BigDecimalArrayMap<>(0, 10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMakeKeyFromInt() {
        System.out.println("makeKeyFromInt");
        int k = 1;
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.makeKeyFromInt(k);
        assertEquals(expResult, result);
    }

    @Test
    public void testPut() {
        System.out.println("put");
        instance.put(BigDecimal.ONE, "1");
        assertEquals("1", instance.get(BigDecimal.ONE));

    }

    @Test
    public void testPutRound() {
        System.out.println("putRound");
        instance.put(new BigDecimal("1.04"), "1");
        assertEquals("1", instance.get(BigDecimal.ONE));
    }

}
