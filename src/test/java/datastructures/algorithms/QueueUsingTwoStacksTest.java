package datastructures.algorithms;

import algorithms.QueueUsingTwoStacks;
import datastructures.adt.Queue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class QueueUsingTwoStacksTest {
    private Queue<String> queue;

    @Before
    public void setUp() {
        queue = new QueueUsingTwoStacks<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue("hi");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeue() {
        queue.enqueue("hi");
        queue.enqueue("hello");
        queue.enqueue("hey");
        assertFalse(queue.isEmpty());

        assertEquals("hi",queue.dequeue());
        assertEquals("hello",queue.dequeue());

        queue.enqueue("bye");

        assertEquals("hey",queue.dequeue());

    }

    @Test
    public void testSize() {
        queue.enqueue("hi");
        queue.enqueue("hello");
        queue.enqueue("hey");
        assertFalse(queue.isEmpty());
        assertEquals(3,queue.size());
        assertEquals("hi",queue.dequeue());
        assertEquals("hello",queue.dequeue());

        assertEquals(1,queue.size());
        queue.enqueue("bye");
        assertEquals(2,queue.size());
        assertEquals("hey",queue.dequeue());

    }
}
