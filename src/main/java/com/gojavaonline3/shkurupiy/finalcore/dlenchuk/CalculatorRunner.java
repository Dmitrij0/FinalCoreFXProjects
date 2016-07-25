package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;


import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.tools.calculator.Calculator;

public class CalculatorRunner {

    private static final String EXPRESSION = "((-3 + 2)*(2  +4)/(3-1) + (1 - 5))";

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(EXPRESSION));
        System.out.println(calculator.getExpression());
        System.out.println(calculator.getResult());
        System.out.println(calculator);
        System.out.println(new Calculator());
        System.out.println(new Calculator(EXPRESSION));
    }

}
