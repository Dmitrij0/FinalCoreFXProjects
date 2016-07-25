package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes;

import java.util.Collection;

/**
 * Prime numbers contract
 *
 * @author Dmitrij Lenchuk
 */
public interface PrimeNumbers extends Iterable<Integer> {

    int getHighBound();

    long getElapsedNanoTime();

    int size();

    boolean prime(int number);

    boolean containsAll(Collection<Integer> c);

    Object[] toArray();

}
