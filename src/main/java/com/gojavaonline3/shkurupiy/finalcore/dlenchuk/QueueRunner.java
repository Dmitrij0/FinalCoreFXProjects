package com.gojavaonline3.shkurupiy.finalcore.dlenchuk;

import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo.EmptyQueueException;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo.FifoQueue;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo.LifoQueue;
import com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo.Queue;

public class QueueRunner {

    private static final Integer[] TEST_DATA = new Integer[] {
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100
    };

    public static void main(String[] args) {

        queue(new LifoQueue<>());

        System.out.println();

        queue(new FifoQueue<>());

    }

    private static void queue(Queue<Integer> queue) {
        System.out.println("----------------------- " + queue.getClass().getSimpleName() +
                " -----------------------");
        for (Integer item : TEST_DATA) {
            queue.push(item);
            System.out.println(queue.getClass().getSimpleName() + ".push() -> " + item);
            System.out.println(queue.getClass().getSimpleName() + " = " + queue);
        }
        while (queue.size() != 0) {
            System.out.println(queue.getClass().getSimpleName() + ".pop() = " + queue.pop());
            System.out.println(queue.getClass().getSimpleName() + " = " + queue);
        }
        System.out.println(queue.getClass().getSimpleName() + ".pop() = " + queue.pop());
        System.out.println(queue.getClass().getSimpleName() + " = " + queue);

        try {
            System.out.print(queue.getClass().getSimpleName() + ".peek() = ");
            System.out.println(queue.peek());
        } catch (EmptyQueueException e) {
            System.out.println(e);
        }

    }

}
