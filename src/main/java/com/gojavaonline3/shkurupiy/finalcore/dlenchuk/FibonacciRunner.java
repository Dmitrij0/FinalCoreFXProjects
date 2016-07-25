package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.Fibonacci;

public class FibonacciRunner {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(0, true);

        long timePoint = System.nanoTime();
        fibonacci.calculate();
        System.out.println("Elapsed Time: " + (System.nanoTime() - timePoint) / 1_000_000 + "ms");
        System.out.println(fibonacci);
    }

}
