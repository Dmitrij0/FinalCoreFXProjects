package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo;

/**
 * The class of a FIFO queue
 *
 * @author Dmitrij Lenchuk
 */
public class FifoQueue<T> extends AbstractQueue<T> implements Queue<T>{

    @Override
    public T pop() {
        if (size() == 0) {
            return null;
        }

        Item<T> popItem = getFirstItem();
        switch (size()) {
            case 1:
                clear();
                return popItem.getValue();
            default:
                setFirstItem(popItem.getPrev());
                getFirstItem().setNext(null);
                decSize();
                return popItem.getValue();
        }
    }

    @Override
    public T peek() throws EmptyFifoException {
        if (size() == 0) {
            throw new EmptyFifoException();
        }
        return pop();
    }

}
