package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.BigInt;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.BigNumber;

/**
 * The class calculates a factorial and save a result inside
 *
 * @author Dmitrij Lenchuk
 */
public class Factorial {

    public static final int MAX_NUMBER_OF_FACTORIAL_ARGUMENT = 1000;

    private int argument;
    private BigNumber factorial;
    private boolean calculated;

    public Factorial(int argument) {
        this.argument = argument;
    }

    public int getArgument() {
        return argument;
    }

    public void setArgument(int argument) {
        if (this.argument == argument) {
            return;
        }
        this.argument = argument;
        calculated = false;
        factorial = null;
    }

    public BigNumber getFactorial() {
        return factorial;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public BigNumber calculate() {
        if (calculated) {
            return factorial;
        }
        if (argument < 1) {
            throw new IllegalArgumentException("The argument must be greater then '0'. The argument is '" + argument + '\'');
        }
        if (argument > MAX_NUMBER_OF_FACTORIAL_ARGUMENT) {
            throw new IllegalArgumentException("Argument of calculate function must be less or equals " +
                    MAX_NUMBER_OF_FACTORIAL_ARGUMENT);
        }
        factorial = fact(new BigInt(String.valueOf(argument)));
        calculated = true;
        return factorial;
    }

    private BigNumber fact(BigNumber number) {
        return number.equals(new BigInt("1")) ? number : number.multiply(fact(number.subtract(new BigInt("1"))));
    }

    @Override
    public String toString() {
        return "Factorial(" + argument + ") = " + factorial;
    }
}
