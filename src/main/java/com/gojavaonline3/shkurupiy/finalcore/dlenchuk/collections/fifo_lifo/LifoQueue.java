package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo;

/**
 * The class of a LIFO queue
 *
 * @author Dmitrij Lenchuk
 */
public class LifoQueue<T> extends AbstractQueue<T> implements Queue<T>{

    @Override
    public T pop() {
        if (size() == 0) {
            return null;
        }

        Item<T> popItem = getLastItem();
        switch (size()) {
            case 1:
                clear();
                return popItem.getValue();
            default:
                setLastItem(popItem.getNext());
                getLastItem().setPrev(null);
                decSize();
                return popItem.getValue();
        }
    }

    @Override
    public T peek() throws EmptyLifoException {
        if (size() == 0) {
            throw new EmptyLifoException();
        }
        return pop();
    }

}
