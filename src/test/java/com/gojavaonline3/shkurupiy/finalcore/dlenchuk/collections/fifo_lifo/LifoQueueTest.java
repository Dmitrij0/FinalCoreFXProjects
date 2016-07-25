package com.gojavaonline3.shkurupiy.finalcore.dlenchuk.collections.fifo_lifo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

public class LifoQueueTest {

    private LifoQueue<String> stack;

    private String[] testData =
            new String[]{"First string", "Second string", "Third string", "Fourth string", "Last string"};

    @Before
    public void setUp() throws Exception {
        stack = new LifoQueue<>();
        Arrays.stream(testData).forEach(item -> stack.push(item));
    }

    @Test
    public void push() throws Exception {
        assertEquals("Not all item is pushed", testData.length, stack.size());
        Iterator<String> iterator = stack.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            assertEquals("An error in the algorithm of LIFO", testData[counter++], iterator.next());
        }
        assertTrue("It can't read all items", counter == testData.length);
    }

    @Test
    public void pop() throws Exception {
        for (int i = testData.length - 1; i >= 0; i--) {
            assertEquals("Pull method is wrong", testData[i], stack.pop());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals("Null mast be returned when stack is empty", null, stack.pop());
        }
    }

    @Test(expected = EmptyLifoException.class)
    public void peek() throws Exception {
        for (int i = testData.length - 1; i >= 0; i--) {
            assertEquals("Pull method is wrong", testData[i], stack.peek());
        }
        stack.peek();
    }

    @Test
    public void getFirstItem() throws Exception {
        assertEquals("First item is wrong", testData[0], stack.getFirstItem().getValue());
    }

    @Test
    public void getLastItem() throws Exception {
        assertEquals("Last item is wrong", testData[testData.length - 1], stack.getLastItem().getValue());
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse("The stack is not empty", stack.isEmpty());
        stack.clear();
        assertTrue("The stack is empty", stack.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals("The size is wrong", testData.length, stack.size());
    }

    @Test
    public void clear() throws Exception {
        stack.clear();
        assertEquals("The first item is not null", stack.getFirstItem(), null);
        assertEquals("The last item is not null", stack.getLastItem(), null);
        assertEquals("The last item is not null", stack.size(), 0);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Queue[First string | Second string | Third string | Fourth string | Last string]", stack.toString());
    }

}