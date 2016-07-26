package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PrimeNumbersTest {

    private final static int HIGH_BOUND = 100;
    private final static Integer[] ORIGINAL_DATA = new Integer[] {
            1, 2, 3, 5, 7, 11, 13, 17, 19, 23,
            29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89,97
    };

    private PrimeNumbers primes;
    private PrimeNumbers primesOptimized;

    @Before
    public void setUp() throws Exception {
        primes = new PrimeNumbersList(HIGH_BOUND);
        primesOptimized = new PrimeNumbersListOptimized(HIGH_BOUND);
    }

    @Test
    public void getMaxNumber() throws Exception {
        assertEquals(HIGH_BOUND, primes.getHighBound());
        assertEquals(HIGH_BOUND, primesOptimized.getHighBound());
    }

    @Test
    public void getElapsedNanoTime() throws Exception {
        assertTrue(primes.getElapsedNanoTime() > 0);
        assertTrue(primesOptimized.getElapsedNanoTime() > 0);
    }

    @Test
    public void size() throws Exception {
        assertEquals(ORIGINAL_DATA.length, primes.size());
        assertEquals(ORIGINAL_DATA.length, primesOptimized.size());
    }

    @Test
    public void prime() throws Exception {
        for (int i = 0; i < 100; i++) {
            assertEquals(
                    "'" + (i + 1) + "' is " + (Arrays.binarySearch(ORIGINAL_DATA, i + 1) < 0 ? "not " : "") + "a primes",
                    Arrays.binarySearch(ORIGINAL_DATA, i + 1) >= 0,
                    primes.prime(i + 1)
            );
            assertEquals(
                    "'" + (i + 1) + "' is " + (Arrays.binarySearch(ORIGINAL_DATA, i + 1) < 0 ? "not " : "") + "a primes",
                    Arrays.binarySearch(ORIGINAL_DATA, i + 1) >= 0,
                    primesOptimized.prime(i + 1)
            );
        }
    }

    @Test
    public void containsAll() throws Exception {
        assertFalse(primes.containsAll(Arrays.asList(10, 20, 30, 12, 4)));
        assertTrue(primes.containsAll(Arrays.asList(ORIGINAL_DATA)));
        assertFalse(primesOptimized.containsAll(Arrays.asList(10, 20, 30, 12, 4)));
        assertTrue(primesOptimized.containsAll(Arrays.asList(ORIGINAL_DATA)));
    }

    @Test
    public void toArray() throws Exception {
        assertArrayEquals(ORIGINAL_DATA, primes.toArray());
        assertArrayEquals(ORIGINAL_DATA, primesOptimized.toArray());
    }

    @Test
    public void iterator() throws Exception {
        int i = 0;
        for (Integer prime : primes) {
            assertEquals(ORIGINAL_DATA[i++], prime);
        }
        i = 0;
        for (Integer prime : primesOptimized) {
            assertEquals(ORIGINAL_DATA[i++], prime);
        }
    }

    @Test
    public void testToString() throws Exception {
        String result = "";
        long counter = 0;
        for (Integer prime : ORIGINAL_DATA) {
            counter++;
            result += String.format("|%10d" + (counter % 10 == 0 ? "|\n" : ""), prime);
        }
        assertEquals(result, primes.toString());
        assertEquals(result, primesOptimized.toString());
    }

}