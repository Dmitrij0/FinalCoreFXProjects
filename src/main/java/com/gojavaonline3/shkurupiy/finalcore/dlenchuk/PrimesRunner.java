package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;


import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes.AbstractPrimeNumbers;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes.PrimeNumbersList;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes.PrimeNumbersListOptimized;

import java.lang.reflect.InvocationTargetException;

public class PrimesRunner {

    private static final int HIGH_BOUND = 1_000;

    private static final int STATISTICS_HIGH_BOUND = 100_000;
    private static final int STATISTICS_COUNT_OF_ITERATIONS = 100;

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {

        System.out.println(new PrimeNumbersListOptimized(HIGH_BOUND));

        System.out.println();

        report(PrimeNumbersList.class);

        System.out.println();

        report(PrimeNumbersListOptimized.class);
    }

    private static void report(Class classPrime)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        long totalTime = 0;
        System.out.println(classPrime.getSimpleName() + ": ");
        AbstractPrimeNumbers prime;
        for (int i = 0; i < STATISTICS_COUNT_OF_ITERATIONS; i++) {
            prime = (AbstractPrimeNumbers) classPrime.getConstructors()[0].newInstance(STATISTICS_HIGH_BOUND);
            totalTime += prime.getElapsedNanoTime();
            System.out.print("." + ((i + 1) % 100 == 0 ? '\n' : ""));
        }
        System.out.println();
        System.out.println("\tAverage time: " + totalTime / (1_000_000 * STATISTICS_COUNT_OF_ITERATIONS) + "ms");
    }

}
