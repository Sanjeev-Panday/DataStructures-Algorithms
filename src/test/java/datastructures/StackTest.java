package datastructures;

import datastructures.adt.Stack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StackTest {
    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new StackUsingLinkedList<Integer>();
    }
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPushOperation() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertEquals(1,stack.size());
    }

    @Test
    public void testPopOperation() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        assertEquals(2,(int)stack.pop());
    }

    @Test
    public void testSize() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4,(int)stack.size());
    }
}
