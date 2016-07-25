package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FifoQueueTest {

    private FifoQueue<String> queue;

    private String[] testData =
            new String[]{"First string", "Second string", "Third string", "Fourth string", "Last string"};

    @Before
    public void setUp() throws Exception {
        queue = new FifoQueue<>();
        Arrays.stream(testData).forEach(item -> queue.push(item));
    }

    @Test
    public void pop() throws Exception {
        for (String item : testData) {
            assertEquals("Pull method is wrong", item, queue.pop());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals("Null mast be returned when queue is empty", null, queue.pop());
        }
    }

    @Test(expected = EmptyFifoException.class)
    public void peek() throws Exception {
        for (String item : testData) {
            assertEquals("Pull method is wrong", item, queue.peek());
        }
        queue.peek();
    }

    @Test
    public void size() throws Exception {
        assertEquals("The size is wrong", testData.length, queue.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse("The queue is not empty", queue.isEmpty());
        queue.clear();
        assertTrue("The queue is empty", queue.isEmpty());
    }

    @Test
    public void clear() throws Exception {
        queue.clear();
        assertEquals("The first item is not null", queue.getFirstItem(), null);
        assertEquals("The last item is not null", queue.getLastItem(), null);
        assertEquals("The last item is not null", queue.size(), 0);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Queue[First string | Second string | Third string | Fourth string | Last string]", queue.toString());
    }

}