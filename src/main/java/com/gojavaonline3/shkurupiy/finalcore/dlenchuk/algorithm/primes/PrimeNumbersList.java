package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prime numbers by a clear Eratosthenes algorithm
 *
 * @author Dmitrij Lenchuk
 */
public class PrimeNumbersList extends AbstractPrimeNumbers {

    public PrimeNumbersList(int maxNumber) {
        super(maxNumber);
    }

    List<Integer> calculate() {
        final List<Integer> primes = new ArrayList<>();
        final boolean[] prime = new boolean[getHighBound()];

        Arrays.fill(prime, true);

        for (int step = 2; step < Math.sqrt(getHighBound()); step++) {
            for (int itemNumber = step*2; itemNumber < getHighBound(); itemNumber += step) {
                prime[itemNumber] = false;
            }
        }

        for (int i = 1; i < getHighBound(); i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
