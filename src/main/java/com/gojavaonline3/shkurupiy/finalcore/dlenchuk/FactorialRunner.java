package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.Factorial;

public class FactorialRunner {

    public static void main(String[] args) {
        final Factorial factorial = new Factorial(100);

        long timePoint = System.nanoTime();
        System.out.println(factorial.calculate());
        System.out.println("Elapsed Time: " + (System.nanoTime() - timePoint) / 1_000_000 + "ms");
        System.out.println(factorial);
    }

}
