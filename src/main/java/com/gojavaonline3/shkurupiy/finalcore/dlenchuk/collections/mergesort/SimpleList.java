package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.mergesort;

import java.util.Iterator;

/**
 * The contract of SimpleArrayList
 *
 * @author  Dmitrij Lenchuk
 * @since 05.06.2016.
 */
public interface SimpleList<T extends Comparable<T>> extends Iterable<T> {

    T get(int index);

    int indexOf(T Item);

    boolean add(T item);

    void add(int index, T item);

    void add(T[] list);

    boolean remove(T item);

    T remove(int index);

    int length();

    SimpleList<T> sort();

    T min();

    T max();

    Iterator<T> iterator();

}
