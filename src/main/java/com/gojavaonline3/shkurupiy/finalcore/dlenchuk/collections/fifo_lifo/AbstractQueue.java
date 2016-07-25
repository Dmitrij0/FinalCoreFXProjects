package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo;

import java.util.Iterator;

/**
 * The abstract class of FIFO/LIFO queues
 *
 * @author Dmitrij Lenchuk
 */
abstract class AbstractQueue<T> implements Queue<T>, Iterable<T> {

    private Item<T> firstItem;
    private Item<T> lastItem;
    private int size;

    public void push(T value) {
        Item<T> currItem;
        if (isEmpty()) {
            currItem = new Item<>(value, null, null);
            setFirstItem(currItem);
            setLastItem(currItem);
        } else {
            currItem = new Item<>(value, getLastItem(), null);
            getLastItem().setPrev(currItem);
            setLastItem(currItem);
        }
        incSize();
    }

    public abstract T pop();

    public abstract T peek() throws EmptyQueueException;

    Item<T> getFirstItem() {
        return firstItem;
    }

    void setFirstItem(Item<T> firstItem) {
        this.firstItem = firstItem;
    }

    Item<T> getLastItem() {
        return lastItem;
    }

    void setLastItem(Item<T> lastItem) {
        this.lastItem = lastItem;
    }

    @Override
    public int size() {
        return size;
    }

    private void incSize() {
        size++;
    }

    void decSize() {
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        firstItem = null;
        lastItem = null;
        size = 0;
    }

    class Item<TI> {
        final private TI value;
        private Item<TI> next;
        private Item<TI> prev;

        Item(TI value, Item<TI> next, Item<TI> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        TI getValue() {
            return value;
        }

        Item<TI> getNext() {
            return next;
        }

        void setNext(Item<TI> next) {
            this.next = next;
        }

        Item<TI> getPrev() {
            return prev;
        }

        boolean hasPrev() {
            return prev != null;
        }

        void setPrev(Item<TI> prev) {
            this.prev = prev;
        }

    }

    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private Item<T> currItem;

        QueueIterator() {
            this.currItem = new Item<>(null, null, getFirstItem());
        }

        public boolean hasNext() {
            return currItem.hasPrev();
        }

        public T next() {
            currItem = currItem.getPrev();
            return currItem.getValue();
        }

    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "The queue is empty";
        }
        StringBuilder stringBuilder = new StringBuilder("Queue[");
        forEach(item -> stringBuilder.append(item).append(" | "));
        stringBuilder.append(']');
        return stringBuilder.substring(0, stringBuilder.length() - 4) + ']';
    }

}
