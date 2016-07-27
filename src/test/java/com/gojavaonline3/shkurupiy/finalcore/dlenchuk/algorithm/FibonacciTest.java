package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.BigInt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class FibonacciTest {

    private Fibonacci fibonacci;

    private int count;
    private boolean leadZero;
    private BigInt[] expected;

    public FibonacciTest(int count, boolean leadZero, BigInt[] expected) {
        this.count = count;
        this.leadZero = leadZero;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: F({0}, {1}) {2}")
    public static Iterable<Object[]> testDataStock() {
        return Arrays.asList(new Object[][]{
                {1, true, new BigInt[]{new BigInt("0")}},
                {1, false, new BigInt[]{new BigInt("1")}},
                {5, true, new BigInt[]{new BigInt("0"), new BigInt("1"), new BigInt("1"), new BigInt("2"), new BigInt("3")}},
                {5, false, new BigInt[]{new BigInt("1"), new BigInt("1"), new BigInt("2"), new BigInt("3"), new BigInt("5")}}
        });
    }

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci(count, leadZero);
        fibonacci.calculate();
    }

    @Test
    public void calculate() throws Exception {
        assertArrayEquals("Wrong algorithm", expected, fibonacci.list());
    }


    @Test
    public void getCount() throws Exception {
        assertEquals("An Error of a get or set of the counter", count, fibonacci.getCount());
    }

    @Test
    public void setCount() throws Exception {
        fibonacci.setCount(count + 10);
        assertEquals("An Error of a get or set of the counter", count + 10, fibonacci.getCount());
    }

    @Test
    public void isLeadZero() throws Exception {
        assertEquals("An Error of a get or set of the lead zero", leadZero, fibonacci.isLeadZero());
    }

    @Test
    public void setLeadZero() throws Exception {
        fibonacci.setLeadZero(!leadZero);
        assertEquals("An Error of a get or set of the lead zero", !leadZero, fibonacci.isLeadZero());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Error in the string",
                "Fibonacci(" + count + "){" + Arrays.toString(fibonacci.list()) + '}', fibonacci.toString());
    }

}