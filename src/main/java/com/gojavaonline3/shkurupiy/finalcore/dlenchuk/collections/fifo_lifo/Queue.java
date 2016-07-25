package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo;

/**
 * The contract of LIFO/FIFO queues
 * */
public interface Queue<T> extends Iterable<T> {

    int size();

    void push(T value);

    T pop();

    T peek() throws EmptyQueueException;

    boolean isEmpty();

    void clear();
}
