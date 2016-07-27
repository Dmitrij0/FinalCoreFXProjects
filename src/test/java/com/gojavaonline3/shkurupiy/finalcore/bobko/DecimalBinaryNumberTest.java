package com.gojavaonline3.shkurupiy.finalcore.bobko;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalBinaryNumberTest {

    DecimalBinaryNumber dBNumber;

    @Before
    public void init() {

        dBNumber = new DecimalBinaryNumberConverter();

    }

    @Test
    public void testInit() {
        assertEquals(dBNumber.getDecimalValue(), "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitBadNumberSystem() {
        new DecimalBinaryNumberConverter("0b123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitBadArgument() {
        new DecimalBinaryNumberConverter("NotNumberString123");
    }

    @Test
    public void testCreateBinaryGetBinary() throws Exception {
        dBNumber = new DecimalBinaryNumberConverter("0b101");
        assertEquals(dBNumber.getBinaryValue(), "101");
    }

    @Test
    public void testCreateDecimalGetBinary() throws Exception {
        dBNumber = new DecimalBinaryNumberConverter("15");
        assertEquals(dBNumber.getBinaryValue(), "1111");
    }

    @Test
    public void testCreateBinaryGetDecimal() throws Exception {
        dBNumber = new DecimalBinaryNumberConverter("0b1010");
        assertEquals(dBNumber.getDecimalValue(), "10");
    }

    @Test
    public void testCreateDecimalGetDecimal() throws Exception {
        dBNumber = new DecimalBinaryNumberConverter("1234");
        assertEquals(dBNumber.getDecimalValue(), "1234");
    }

    @Test
    public void testSetBinaryValue() throws Exception {
        dBNumber.setValue("0b1010");
        assertEquals(dBNumber.getBinaryValue(), "1010");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNotBinaryValue() throws Exception {
        dBNumber.setValue("0b123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBadFormatBinaryValue() throws Exception {
        dBNumber.setValue("NotNumberString123");
    }

    @Test
    public void testSetDecimalValue() throws Exception {
        dBNumber.setValue("123");
        assertEquals(dBNumber.getDecimalValue(), "123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBadFormatDecimalValue() throws Exception {
        dBNumber.setValue("NotNumberString123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeDecimalValue() throws Exception {
        dBNumber.setValue("-123");
    }

}