// Project 4 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Joseph Kim (906678863)
package dailymixes;

import org.junit.Assert.*;
import queue.EmptyQueueException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the ArrayQueue class.
 * 
 * @author Jo
 * @version Nov 9, 2025
 */
public class ArrayQueueTest
    extends TestCase
{
    private ArrayQueue<String> queue;
    private ArrayQueue<String> queue2;

    // ----------------------------------------------------------
    /**
     * Creates a new ArrayQueue object.
     */
    public void setUp()
    {
        queue = new ArrayQueue<String>();
        queue2 = new ArrayQueue<String>(2);
    }


    // ----------------------------------------------------------
    /**
     * Checks that queue is empty. Adds 2 strings. Checks that size is 2. Checks
     * that dequeueing equals test. Checks that size is now 1. Checks that the
     * string at the front is test2.
     */
    public void testEnqueueDequeue()
    {
        assertTrue(queue.isEmpty());
        queue.enqueue("test");
        queue.enqueue("test2");
        assertEquals(2, queue.getSize());
        assertEquals("test", queue.dequeue());
        assertEquals(1, queue.getSize());
        assertEquals("test2", queue.getFront());
        assertEquals("test2", queue.dequeue());
    }


    // ----------------------------------------------------------
    /**
     * Adds 3 items. Checks that queue has correctly doubled the underlying
     * array length.
     */
    public void testEnsureCapacity()
    {
        queue2.enqueue("test");
        queue2.enqueue("test2");
        queue2.enqueue("test3");
        assertEquals(queue2.getLengthOfUnderlyingArray(), 4);

    }


    // ----------------------------------------------------------
    /**
     * Checks that dequeueing an empty queue throws an EmptyQueueException.
     */
    public void testDequeueEmpty()
    {
        Exception thrown = null;
        try
        {
            queue.dequeue();
        }
        catch (EmptyQueueException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    // ----------------------------------------------------------
    /**
     * Checks that getting the front of an empty queue throws an
     * EmptyQueueException.
     */
    public void testGetFrontEmpty()
    {
        Exception thrown = null;
        try
        {
            queue.getFront();
        }
        catch (EmptyQueueException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    // ----------------------------------------------------------
    /**
     * Checks that getting the toArray of an empty object returns an
     * EmptyQueueException.
     */
    public void testToArrayEmpty()
    {
        Exception thrown = null;
        try
        {
            queue.toArray();
        }
        catch (EmptyQueueException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    // ----------------------------------------------------------
    /**
     * Creates a new ArrayQueue. Enqueues 2 items. Clears. Checks that queue is
     * empty. Enqueues another item. Checks that queue does not equal new queue.
     */
    public void testClear()
    {
        ArrayQueue<String> other = new ArrayQueue<String>();
        queue.enqueue("test");
        queue.enqueue("test2");
        queue.clear();
        assertTrue(queue.isEmpty());
        other.enqueue("test3");
        assertFalse(queue.equals(other));
    }


    // ----------------------------------------------------------
    /**
     * Checks that queue is not equal to queue2 when queue is empty. Checks that
     * queue is not equal to queue2 when the sizes are different. Checks that
     * queue is not equal to queue2 when 1 value is different. Checks that queue
     * is equal to queue2 when they contain the same values in order.
     */
    public void testEquals()
    {
        assertFalse(queue.equals(queue2));
        queue2.enqueue("test");
        assertFalse(queue.equals(queue2));
        queue2.enqueue("test2");
        queue.enqueue("test");
        queue.enqueue("test3");
        assertFalse(queue.equals(queue2));
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("test");
        queue.enqueue("test2");
        assertTrue(queue.equals(queue2));
    }


    // ----------------------------------------------------------
    /**
     * Checks that the toString of two objects return correctly.
     */
    public void testToString()
    {
        queue.enqueue("test");
        queue.enqueue("test2");
        String s = queue.toString();
        assertTrue(s.equals("[test, test2]"));

    }


    // ----------------------------------------------------------
    /**
     * Checks that the toArray of two objects return correctly.
     */
    public void testToArray()
    {
        queue.enqueue("test");
        queue.enqueue("test2");
        Object[] arr = queue.toArray();
        assertEquals(2, arr.length);
    }
}
