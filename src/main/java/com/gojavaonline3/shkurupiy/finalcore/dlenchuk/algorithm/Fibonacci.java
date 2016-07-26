package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.BigInt;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.BigNumber;

import java.util.Arrays;

/**
 * The class compute a Fibonacci sequence and save a result inside as an array
 *
 * @author Dmitrij Lenchuk
 */
public class Fibonacci {

//    public final int MAX_NUMBER_OF_FIBONACCI = 1000;

    private BigNumber[] list;
    private int count;
    private boolean leadZero;

    private boolean calculated;

    public Fibonacci(int count) {
        setCount(count);
    }

    public Fibonacci(int count, boolean leadZero) {
        this.leadZero = leadZero;
        setCount(count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) throws IllegalArgumentException {
        if (count < 1) {
            throw new IllegalArgumentException("The count must be greater then '0'. The count is '" + count + '\'');
        }
/*
        if (count > MAX_NUMBER_OF_FIBONACCI) {
            throw new IllegalArgumentException("The count must be less or equals '" + MAX_NUMBER_OF_FIBONACCI +
                    "\'. The count is '" + count + '\'');
        }
*/
        calculated = false;
        list = new BigNumber[this.count = count];
    }

    public boolean isLeadZero() {
        return leadZero;
    }

    public void setLeadZero(boolean leadZero) {
        if (this.leadZero != leadZero) {
            this.leadZero = leadZero;
            calculated = false;
            list = new BigNumber[count];
        }
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void calculate() {
        if (calculated) {
            return;
        }
        for (int i = 0; i < count; i++) {
            list[i] = i == 0 ? leadZero ? new BigInt("0") : new BigInt("1") :
                    i == 1 ? new BigInt("1") : list[i - 2].add(list[i - 1]);
        }
        calculated = true;
    }

    public BigNumber[] list() {
        return list;
    }

    @Override
    public String toString() {
        return calculated ? "Fibonacci(" + count + "){" + Arrays.toString(list) + '}' : "Fibonacci is not calculated";
    }
}
