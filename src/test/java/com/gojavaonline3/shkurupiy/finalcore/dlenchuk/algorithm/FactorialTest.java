package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.BigInt;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FactorialTest {

    private Factorial factorial;

    private static final int ARGUMENT_OF_FACTORIAL = 10;
    private static final int ARGUMENT_OF_FACTORIAL_SET = 5;
    private static final BigInt FACTORIAL = new BigInt("3628800");

    @Before
    public void setUp() throws Exception {
        factorial = new Factorial(ARGUMENT_OF_FACTORIAL);
        factorial.calculate();
    }

    @Test
    public void getArgument() throws Exception {
        assertEquals(ARGUMENT_OF_FACTORIAL, factorial.getArgument());
    }

    @Test
    public void setArgument() throws Exception {
        factorial.setArgument(ARGUMENT_OF_FACTORIAL_SET);
        factorial.calculate();
        assertEquals(ARGUMENT_OF_FACTORIAL_SET, factorial.getArgument());
    }

    @Test
    public void getFactorial() throws Exception {
        assertEquals(ARGUMENT_OF_FACTORIAL, factorial.getArgument());
    }

    @Test
    public void isCalculated() throws Exception {
        assertTrue(factorial.isCalculated());
        factorial.setArgument(ARGUMENT_OF_FACTORIAL_SET);
        assertFalse(factorial.isCalculated());
        factorial.calculate();
        assertTrue(factorial.isCalculated());
    }

    @Test
    public void calculate() throws Exception {
        assertTrue(FACTORIAL.equals(factorial.getFactorial()));
        assertTrue(factorial.isCalculated());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Factorial(" + ARGUMENT_OF_FACTORIAL + ") = " + FACTORIAL, factorial.toString());
    }

}