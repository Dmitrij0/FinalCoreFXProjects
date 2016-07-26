package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;


import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.Calculator;

public class CalculatorRunner {

    private static final String EXPRESSION = "((-3298347568923765 + 22349856238975834)*(22930845793847593475  +43984759384759)/(328934753987598347-1123123) + (123131 - 5123123))";

    public static void main(String[] args) {

        System.out.println(new Calculator(EXPRESSION));

    }

}
