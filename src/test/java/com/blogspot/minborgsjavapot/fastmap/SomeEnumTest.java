package com.blogspot.minborgsjavapot.fastmap;

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
public class SomeEnumTest {

    public SomeEnumTest() {
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

    @Test
    public void testFindByValue() {
        System.out.println("findByValue");
        int value = 1;
        SomeEnum expResult = SomeEnum.BERT;
        SomeEnum result = SomeEnum.findByValue(value);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindByLuckyNumber() {
        System.out.println("findByLuckyNumber");
        int value = 13;
        SomeEnum expResult = SomeEnum.SOME_DUDE;
        SomeEnum result = SomeEnum.findByLuckyNumber(value);
        assertEquals(expResult, result);
    }

}
