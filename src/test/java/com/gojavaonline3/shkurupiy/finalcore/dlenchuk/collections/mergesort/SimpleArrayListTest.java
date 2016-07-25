package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.mergesort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> simpleArrayList;
    private static final Integer[] testData = new Integer[] {
            10, 21, 0, 55, -10, 10, 20, 21, -23, 55, 68, 100
    };

    @Before
    public void setUp() throws Exception {
        simpleArrayList = new SimpleArrayList<>(testData);
    }

    @Test
    public void get() throws Exception {
        assertEquals(testData[6], simpleArrayList.get(6));
    }

    @Test
    public void indexOf() throws Exception {
        assertEquals(Arrays.binarySearch(testData, 0), simpleArrayList.indexOf(0));
    }

    @Test
    public void add() throws Exception {
        assertTrue("Can't add an item", simpleArrayList.add(333));
        assertEquals(Integer.valueOf(333), simpleArrayList.get(simpleArrayList.length() - 1));
    }

    @Test
    public void addByIndex() throws Exception {
        simpleArrayList.add(5, 333);
        assertEquals(Integer.valueOf(333), simpleArrayList.get(5));
    }

    @Test
    public void addArray() throws Exception {
        Integer[] resultArray = new Integer[2*testData.length];
        System.arraycopy(testData, 0, resultArray, 0, testData.length);
        System.arraycopy(testData, 0, resultArray, testData.length, testData.length);
        simpleArrayList.add(testData);
        assertArrayEquals(resultArray, simpleArrayList.getList());
    }

    @Test
    public void remove() throws Exception {
        assertTrue("Can't remove an item", simpleArrayList.remove(testData[4]));
        assertNotEquals(testData[4], simpleArrayList.get(4));
    }

    @Test
    public void remove1() throws Exception {
        simpleArrayList.remove(4);
        assertNotEquals(testData[4], simpleArrayList.get(4));
    }

    @Test
    public void length() throws Exception {
        assertEquals(testData.length, simpleArrayList.length());
    }

    @Test
    public void sort() throws Exception {
        Integer[] sortedData = Arrays.copyOf(testData, testData.length);
        Arrays.sort(sortedData);
        assertArrayEquals(sortedData, ((SimpleArrayList<Integer>) simpleArrayList.sort()).getList());
    }

    @Test
    public void min() throws Exception {
        assertEquals(Integer.valueOf(-23), simpleArrayList.min());
        assertEquals(Integer.valueOf(-23), simpleArrayList.sort().min());
    }

    @Test
    public void max() throws Exception {
        assertEquals(Integer.valueOf(100), simpleArrayList.max());
        assertEquals(Integer.valueOf(100), simpleArrayList.sort().max());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("IntSimpleArrayList(min=-23;max=100){" +
                "list=" + Arrays.toString(testData) +
                '}', simpleArrayList.toString());
    }

}