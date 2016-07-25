package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prime numbers by an optimized Eratosthenes algorithm
 *
 * @author Dmitrij Lenchuk
 */
public class PrimeNumbersListOptimized extends PrimeNumbersList{

    public PrimeNumbersListOptimized(int maxNumber) {
        super(maxNumber);
    }

    List<Integer> calculate() {
        final List<Integer> primes = new ArrayList<>();
        final boolean[] prime = new boolean[getHighBound()];

        Arrays.fill(prime, true);

        for (int step = 2; step < Math.sqrt(getHighBound()); step++) {
            if (step % 2 != 0 && step % 5 != 0) {
                for (int itemNumber = step * 2; itemNumber < getHighBound(); itemNumber += step) {
                    prime[itemNumber] = false;
                }
            }
        }

        for (int i = 1; i < getHighBound(); i++) {
            if (prime[i] && (i % 2 != 0 || i == 2) && (i % 5 != 0 || i == 5)) {
                primes.add(i);
            }
        }

        return primes;
    }

}
