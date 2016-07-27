package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.algorithm.primes;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * The abstract class for primes numbers
 * Only calculate() method needs to be implemented
 *
 * @author Dmitrij Lenchuk
 */
public abstract class AbstractPrimeNumbers implements PrimeNumbers {

    private final List<Integer> primes;
    private final int highBound;
    private final long elapsedNanoTime;

    AbstractPrimeNumbers(int highBound) {
        this.highBound = highBound;
        long time = System.nanoTime();
        primes = calculate();
        elapsedNanoTime = System.nanoTime() - time;
    }

    abstract List<Integer> calculate();

    public int getHighBound() {
        return highBound;
    }

    public long getElapsedNanoTime() {
        return elapsedNanoTime;
    }

    @Override
    public int size() {
        return primes.size();
    }

    @Override
    public boolean prime(int number) {
        return primes.contains(number);
    }

    @Override
    public boolean containsAll(Collection<Integer> collection) {
        return primes.containsAll(collection);
    }

    @Override
    public Object[] toArray() {
        return primes.toArray();
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    @Override
    public String toString() {
        String result = "";
        long counter = 0;
        for (Integer prime : primes) {
            counter++;
            result += String.format("|%5d" + (counter % 10 == 0 ? "|\n" : ""), prime);
        }
        return result;
    }
}
